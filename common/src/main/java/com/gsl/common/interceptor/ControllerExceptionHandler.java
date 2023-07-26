package com.gsl.common.interceptor;

import com.gsl.common.exception.BaseException;
import com.gsl.common.exception.BizException;
import com.gsl.common.exception.CustomException;
import com.gsl.common.result.ResultInfo;
import com.gsl.common.result.ResultUtil;
import com.gsl.common.result.enums.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fandeshan
 * @description 异常统一处理
 * @date 2023/4/28
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    @Value("${vp.enablePrintGlobalException}")
    private boolean enablePrintGlobalException;

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResultInfo catchException(Exception e) {
        if(enablePrintGlobalException){
            e.printStackTrace();
        }
        final ResultInfo resultInfo = ResultUtil.getFailResult(ResultCode.BIZ_EXCEPTION);
        log.error("system occur business exception: {}",e.getMessage());
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException) e;
            BindingResult result = argumentNotValidException.getBindingResult();
            if (result.hasErrors()) {
                resultInfo.setCode("100000");
                result.getAllErrors().stream().findFirst()
                        .ifPresent(fieldError -> resultInfo.setMessage(fieldError.getDefaultMessage()));
            }
        } else if (e instanceof BindException) {
            ((BindException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage();
            BindingResult result = ((BindException) e).getBindingResult();
            if (result.hasErrors()) {
                result.getAllErrors().stream().findFirst()
                        .ifPresent(fieldError -> resultInfo.setMessage(fieldError.getDefaultMessage()));
            }
        }else if (e instanceof CustomException) {
            //自定义异常类
            CustomException d = (CustomException)e;
            resultInfo.setCode(d.getCode());
            resultInfo.setMessage(d.getMessage());
        }else if (e instanceof BaseException) {
            //自定义异常类
            BaseException b = (BaseException)e;
            resultInfo.setMessage(b.getMessage());
        }else if (e instanceof BizException) {
            //自定义异常类
            BizException b = (BizException)e;
            resultInfo.setMessage(b.getMessage());
        }
        log.info("request controller return fail,return msg {}", resultInfo);
        return resultInfo;
    }
}
