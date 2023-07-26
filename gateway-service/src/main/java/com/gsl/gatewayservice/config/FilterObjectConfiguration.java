package com.gsl.gatewayservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fandeshan
 * @description 过滤配置
 * @date 2023/4/28
 */
@Component
@ConfigurationProperties(prefix = "filter")
@Getter
@Setter
public class FilterObjectConfiguration {
    private List<String> allowedUrl;

    private List<String> referUrls;
}
