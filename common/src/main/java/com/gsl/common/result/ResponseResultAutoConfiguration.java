package com.gsl.common.result;

import com.gsl.common.constants.RequestUriConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 返回result 配置类
 *
 * @author fandeshan
 */
@Configuration
@ComponentScan(basePackageClasses = {ResponseResultHandler.class, ResponseResultInterceptor.class})
public class ResponseResultAutoConfiguration implements WebMvcConfigurer {
    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        registry.addInterceptor(responseResultInterceptor).addPathPatterns("/**")
                .excludePathPatterns(RequestUriConstants.excludeUrls);

    }
}
