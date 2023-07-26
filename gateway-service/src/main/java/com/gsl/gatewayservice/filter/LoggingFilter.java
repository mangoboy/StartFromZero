package com.gsl.gatewayservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

/**
 * @author fandeshan
 * @description 打印日志拦截过滤器
 * @date 2023/4/27
 */
@Slf4j
public class LoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 在请求前打印请求信息
        Instant startTime = Instant.now();
        log.info("Request Begin, Request URL: " + exchange.getRequest().getURI()
                +", " + "Request Method: " + exchange.getRequest().getMethod()
                +"," +"Request Headers: " + exchange.getRequest().getHeaders());

        // 在请求后打印响应信息
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Instant endTime = Instant.now();
            Duration duration = Duration.between(startTime, endTime);
            log.info("Request End ,Response Status Code: " + exchange.getResponse().getStatusCode()
                    +", " + "Response Headers: " + exchange.getResponse().getHeaders()
                    +"," +"Response Time: " + duration.toMillis() + " ms");
        }));
    }

    @Override
    public int getOrder() {
        return -999; // 设置过滤器优先级
    }
}
