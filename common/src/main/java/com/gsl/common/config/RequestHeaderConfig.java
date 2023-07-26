package com.gsl.common.config;

import com.gsl.common.constants.RequestUriConstants;
import com.gsl.common.interceptor.HeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 请求头拦截器配置
 *
 * @author taojirun
 */
@Configuration
@Import(HeaderInterceptor.class)
public class RequestHeaderConfig implements WebMvcConfigurer {

    @Resource
    private HeaderInterceptor headerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(RequestUriConstants.excludeUrls)
                .order(-10);
    }


}
