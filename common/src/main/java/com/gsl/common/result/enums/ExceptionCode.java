package com.gsl.common.result.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum ExceptionCode implements IBundleEnum{

    BUSINESS_EXCEPTION("bussinessException"),
    ;

    private String code;

    ExceptionCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    private static final String EXCEPTION_CODE_PREFIX = "com.gsl.ExceptionCode.";

    @Override
    public String getMessage() {
        try {
            return getMessage(EXCEPTION_CODE_PREFIX + this.code);
        }catch (Exception e){
            log.warn("case error when convert code: {}, exception:{}",this.code,e.getMessage());
            return "";
        }

    }

    @Override
    public String getMessage(Object[] args) {
        try {
            return getMessage(EXCEPTION_CODE_PREFIX + this.code,args);
        }catch (Exception e){
            log.warn("case error when convert code: {}, exception:{}",this.code,e.getMessage());
            return "";
        }
    }
}
