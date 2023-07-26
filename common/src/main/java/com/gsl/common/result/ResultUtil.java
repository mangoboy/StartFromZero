package com.gsl.common.result;

import com.gsl.common.exception.CustomException;
import com.gsl.common.result.enums.IBundleEnum;
import com.gsl.common.result.enums.ResultCode;

/**
 * 返回工具类
 * @author huangshuo
 * @created 2021/5/8
 **/
public class ResultUtil {

    private ResultUtil() {
    }

    public static ResultInfo getSuccessResult(Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultCode.SUCCESS.getCode());
        resultInfo.setMessage(ResultCode.SUCCESS.getMessage());
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo getSuccessResult(String resultMessage, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultCode.SUCCESS.getCode());
        resultInfo.setMessage(resultMessage);
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo getFailResult(Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultCode.BIZ_EXCEPTION.getCode());
        resultInfo.setMessage(ResultCode.BIZ_EXCEPTION.getMessage());
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo getFailResult(IBundleEnum resultCode) {
        return getFailResult(resultCode, null);
    }

    public static ResultInfo getFailResult(String resultCode, String resultMessage, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(resultCode);
        resultInfo.setMessage(resultMessage);
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo getFailResult(IBundleEnum resultCode, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(resultCode.getCode());
        resultInfo.setMessage(resultCode.getMessage());
        resultInfo.setData(data);
        return resultInfo;
    }
    public static ResultInfo getFailResult(Exception e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMessage(e.getMessage());
        resultInfo.setData("");
        if( e instanceof CustomException ){
            resultInfo.setCode(((CustomException)e).getCode());
            return resultInfo;
        }else{
            resultInfo.setCode("10000");
            return resultInfo;
        }
    }

    public static  <T>  ResultInfo<T> buildSuccessResult(T t) {
        ResultInfo<T> resultInfo = new ResultInfo<>();
        resultInfo.setData(t);
        resultInfo.setMessage(ResultCode.SUCCESS.getMessage());
        resultInfo.setCode(ResultCode.SUCCESS.getCode());
        return resultInfo;
    }

    public static <T> ResultInfo<T> buildFailResult(T t) {
        ResultInfo<T> resultInfo = new ResultInfo<>();
        resultInfo.setData(t);
        resultInfo.setCode(ResultCode.FAILED.getCode());
        resultInfo.setMessage(ResultCode.FAILED.getMessage());
        return resultInfo;
    }
    public static <T> ResultInfo<T> buildFailResult(String resultCode, String resultMessage, T t) {
        ResultInfo<T> resultInfo = new ResultInfo<>();
        resultInfo.setData(t);
        resultInfo.setCode(resultCode);
        resultInfo.setMessage(resultMessage);
        return resultInfo;
    }
}
