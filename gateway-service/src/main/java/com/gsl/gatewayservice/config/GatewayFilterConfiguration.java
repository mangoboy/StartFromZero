package com.gsl.gatewayservice.config;

import com.gsl.gatewayservice.filter.AccessFilter;
import com.gsl.gatewayservice.filter.LoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fandeshan
 * @description 拦截器配置类
 * @date 2023/4/27
 */

@Configuration
public class GatewayFilterConfiguration {

    @Autowired
    private FilterObjectConfiguration filterObjectConfiguration;

    @Bean
    public AccessFilter accessFilter() {
        AccessFilter accessFilter = new AccessFilter();
        accessFilter.setAllowedUrl(filterObjectConfiguration.getAllowedUrl());
        return accessFilter;
    }

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }
}
