package com.gsl.common.exception;


import com.gsl.common.result.enums.IBundleEnum;

public class ValidException extends BaseException {

    public ValidException(){
        super();
    }

    public ValidException(String message){
        super(message);
        this.message = message;
    }

    public ValidException(String code, String message) {
        super(code, message);
        this.code = code;
        this.message = message;
    }

    public ValidException(IBundleEnum bundleEnum){
        super(bundleEnum.getMessage());
        this.message = bundleEnum.getMessage();
    }

    public ValidException(IBundleEnum bundleEnum, Object... args){
        super(bundleEnum.getMessage(args));
        this.message = bundleEnum.getMessage(args);
    }
}
