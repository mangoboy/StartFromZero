package com.gsl.common.exception;

/**
 * 基础异常类
 * @author fandeshan
 */
public class BaseException  extends RuntimeException {
    protected String code;

    protected String message;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
