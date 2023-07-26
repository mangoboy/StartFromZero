package com.gsl.common.result.enums;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

public interface IBundleEnum {

    String getCode();
    String getMessage();

    default String getMessage(String code) {
        return getMessage(code,null);
    }
    default String getMessage(String code, Object[] args) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestContext requestContext = new RequestContext(request);
        return requestContext.getMessage(code,args);
    }

    String getMessage(Object[] args);
}
