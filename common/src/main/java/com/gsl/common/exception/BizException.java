package com.gsl.common.exception;

import com.gsl.common.result.enums.IBundleEnum;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Description：
 *
 * @author FANDESHAN761
 * @date 2019/10/26 9:16
 */
public class BizException extends RuntimeException {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    private String errorCode;
    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public BizException() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public static final String EXCEPTION_PREFIX = "com.gsl.resultcode.";
    public BizException(String code) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestContext requestContext = new RequestContext(request);
        String message = null ;
        try{
            message =  requestContext.getMessage(EXCEPTION_PREFIX+code);
        }catch (Exception e){
            throw new RuntimeException("could not found error code!");
        }
        throw new RuntimeException(message);
//        super(message);
    }

    public BizException(IBundleEnum bundleEnum){
        super(bundleEnum.getMessage());
        this.message = bundleEnum.getMessage();
    }
    public BizException(IBundleEnum bundleEnum,Object... args){
        super(bundleEnum.getMessage(args));
        this.message = bundleEnum.getMessage(args);
    }
}
