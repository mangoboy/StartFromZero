package com.gsl.common.redis.porp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * redis 属性值
 */
@Data
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProp {

    private String redisActive = "single";

    private String host;

    private String port = "6379";

    private String password;

    private int database = 0;

    private int timeout = 3000;

    private int connectionMinimumIdleSize = 24;

    private int connectionPoolSize = 64;

    private List<String> cluster;

}