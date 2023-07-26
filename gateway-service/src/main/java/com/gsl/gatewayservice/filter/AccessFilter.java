package com.gsl.gatewayservice.filter;

import com.alibaba.fastjson2.JSON;
import com.gsl.common.constants.TokenConstants;
import com.gsl.common.result.ResultInfo;
import com.gsl.common.result.ResultUtil;
import com.gsl.common.result.enums.ResultCode;
import com.gsl.gatewayservice.feign.RemoteUserService;
import com.gsl.gatewayservice.provider.Knife4jResourceProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fandeshan
 * @description 授权过滤器
 * @date 2023/4/27
 */
@Slf4j
public class AccessFilter implements GlobalFilter, Ordered {

    // TODO: 2023/5/5
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    private RemoteUserService remoteUserService;

    private List<String> allowedUrl;

    private static List<String> staticTypes = Arrays.asList("jpg", "bmp", "gif", "doc", "docx", "rar", "png", "jpeg", "pdf");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //检查请求头中是否包含 Authorization 信息
        String token = exchange.getRequest().getHeaders().getFirst(TokenConstants.AUTHENTICATION);
        String uri = exchange.getRequest().getURI().getPath();
        if (checkUri(uri)) {
            //白名单
            return chain.filter(exchange);
        }
        if (StringUtils.isBlank(token)) {
            return unauthorizedResponse(exchange);
        }
        if (!verifyToken(token)) {
            return unauthorizedResponse(exchange);
        }
        // 如果存在授权信息，则继续处理请求
        return chain.filter(exchange);
    }

    /**
     * 调用IDM接口校验token
     *
     * @param token
     * @return
     */
    public Boolean verifyToken(String token) {
        ResultInfo<Boolean> resultInfo = null;
        try {
            // WebFlux需要异步调用
            Future future = executorService.submit(() -> remoteUserService.verifyToken(token));
            resultInfo = (ResultInfo<Boolean>) future.get();
        } catch (Exception e) {
            log.error("调用远程接口校验token异常:{}", e.getMessage());
        }
        if (resultInfo != null && resultInfo.getCode().equals(ResultCode.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    /**
     * 校验当前URI是否在白名单内
     *
     * @param requestUri
     * @return
     */
    private boolean checkUri(String requestUri) {
        //如果访问为指定静态资源 则认定在白名单之内
        if (checkStaticResource(requestUri)) {
            return true;
        }
        //swagger资源
        if (requestUri.contains(Knife4jResourceProvider.SWAGGER2_URL)) {
            return true;
        }
        if (null != allowedUrl && !allowedUrl.isEmpty()) {
            for (String uri : allowedUrl) {
                boolean checkFlagWithWildcard = uri.indexOf("*") != -1 && requestUri.startsWith(uri.replace("*", ""));
                boolean checkFlagWithFullPath = uri.indexOf("*") == -1 && requestUri.equals(uri);
                if (checkFlagWithWildcard || checkFlagWithFullPath) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断访问地址是否为静态资源
     *
     * @param requestUri 访问地址
     * @return
     */
    private boolean checkStaticResource(String requestUri) {
        String urlType = getUrlStaticType(requestUri);
        if (StringUtils.isBlank(urlType)) {
            return false;
        }
        if (staticTypes.contains(urlType.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * 获取requestUrl的资源类型
     *
     * @param requestUrl 访问地址
     * @return
     */
    public static String getUrlStaticType(String requestUrl) {
        int pos = requestUrl.lastIndexOf(".");
        if (pos == -1) {
            return null;
        }
        return requestUrl.substring(pos + 1);
    }

    /**
     * @param exchange
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @description 响应-没有权限
     * @author taojirun
     * @date 11:00 2023/5/4
     **/
    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange) {
        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        Mono<Void> voidMono = webFluxResponseWriter(exchange.getResponse(), MediaType.APPLICATION_JSON_VALUE,
                HttpStatus.UNAUTHORIZED, "没有权限", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        return voidMono;
    }

    /**
     * 设置webflux模型响应
     *
     * @param response    ServerHttpResponse
     * @param contentType content-type
     * @param status      http状态码
     * @param code        响应状态码
     * @param value       响应内容
     * @return Mono<Void>
     */
    public static Mono<Void> webFluxResponseWriter(ServerHttpResponse response, String contentType, HttpStatus status, Object value, String code) {
        response.setStatusCode(status);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, contentType);
        ResultInfo<?> result = ResultUtil.getFailResult(code, value.toString(), null);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }

    @Override
    public int getOrder() {
        return -100;// 设置过滤器优先级
    }

    public List<String> getAllowedUrl() {
        return allowedUrl;
    }

    public void setAllowedUrl(List<String> allowedUrl) {
        this.allowedUrl = allowedUrl;
    }
}
