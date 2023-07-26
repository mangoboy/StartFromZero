package com.gsl.gatewayservice.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * feign请求头拦截器
 *
 * @author fandeshan
 * @description 请求头传递，解决浏览器内部分请求头丢失问题
 * @date 2023/4/28
 */
@Slf4j
@Configuration
public class FeignReqHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        // 如果当前执行的是子线程（异步任务）RequestContextHolder（ThreadLocal）获取不到request对象
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        try {
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    requestTemplate.header(name, values);
                }
            }
            log.info("接口路径：" + request.getRequestURL().toString());
            Enumeration<String> bodyNames = request.getParameterNames();
            if (bodyNames != null) {
                Map map = new HashMap(16);
                while (bodyNames.hasMoreElements()) {
                    String name = bodyNames.nextElement();
                    String values = request.getParameter(name);
                    requestTemplate.query(name, values);
                    map.put(name, values);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
