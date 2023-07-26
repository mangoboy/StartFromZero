package com.gsl.common.interceptor;

import com.gsl.common.context.UserInfoContextHolder;
import com.gsl.common.utils.UserInfoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义请求头拦截器，将Header数据封装到线程变量中方便获取
 *
 * @author taojirun
 */
@Component
public class HeaderInterceptor implements AsyncHandlerInterceptor {

    private boolean enableDebuggerUser = true;


    private final static String DEBUGGER_USER_ACCOUNT = "DEBUGGER_USER_ACCOUNT";
    private final static String DEBUGGER_USER_NAME = "DEBUGGER_USER_NAME";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String userAccount = UserInfoUtil.getUserAccount(request);
        String userName = UserInfoUtil.getUserName(request);
        if(enableDebuggerUser){
            if (StringUtils.isBlank(userAccount)) {
                userAccount = DEBUGGER_USER_ACCOUNT;
            }
            if (StringUtils.isBlank(userName)) {
                userName = DEBUGGER_USER_NAME;
            }
        }
        UserInfoContextHolder.setUserAccount(userAccount);
        UserInfoContextHolder.setUserName(userName);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        UserInfoContextHolder.remove();
    }
}
