package com.gsl.common.exception;

import com.gsl.common.result.enums.ResultCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fandeshan
 * @description 自定义异常
 * @date 2023/4/28
 */
public class CustomException extends RuntimeException {
    /**
     * 错误码
     * @date 2019-7-16 20:24
     **/
    private String code;
    /**
     * get
     * @date 2019-7-16 20:24
     **/
    public String getCode() {
        return code;
    }
    /**
     *  自定义message
     * @param message parameter
     * @param code parameter
     * @return * @return: null
     **/
    public CustomException(String code, String message) {
        super(message);
        this.code = StringUtils.isNotBlank(code)?code:"100000";
    }
    /**
     * 单一message 固定错误码
     * @param message parameter
     * @return * @return: null
     **/
    public CustomException(String message) {
        super(message);
        this.code = "100000";
    }
    /**
     * ResultCode
     * @param resultCode parameter
     * @return * @return: null
     **/
    public CustomException(ResultCode resultCode) {
        super(resultCode.getMessage());
        System.out.println(resultCode.getMessage());
        System.out.println(resultCode.getCode());
        this.code = resultCode.getCode();
    }
}
