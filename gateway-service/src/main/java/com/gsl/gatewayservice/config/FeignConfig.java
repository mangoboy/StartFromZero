package com.gsl.gatewayservice.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

/**
 * @Description
 * @Author taojirun
 * @create 2023/5/5 23:16
 */

@Configuration
public class FeignConfig {

    //    gateway中无法调用openfeign
    //    Spring Cloud Gateway是基于WebFlux的，是ReactiveWeb，所以HttpMessageConverters不会自动注入
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }


}
