package com.gsl.gatewayservice.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author taojirun
 * @create 2023/5/5 13:39
 */
@Component
@RequiredArgsConstructor
public class Knife4jResourceProvider implements SwaggerResourcesProvider {

    /**
     * api前缀
     */
    private static final String API_PREFIX = "/vpApi/";

    /**
     * swagger2默认的url后缀
     */
    public static final String SWAGGER2_URL = "/v2/api-docs";

    /**
     * 路由定位器
     */
    private final RouteLocator routeLocator;

    /**
     * 网关应用名称
     */
    @Value("${spring.application.name}")
    private String gatewayName;

    /**
     * 获取 Swagger 资源
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        Set<String> routeHosts = new HashSet<>();
        // 1. 获取路由Uri 中的Host ==> 服务注册的name
        routeLocator.getRoutes()
                .filter(route -> route.getUri().getHost() != null
                        && !gatewayName.equals(route.getUri().getHost()))
                .subscribe(route -> routeHosts.add(route.getUri().getHost()));
        // 2. 创建自定义资源
        for (String routeHost : routeHosts) {
            // 后台访问添加服务名前缀
            String serviceUrl = API_PREFIX + routeHost + SWAGGER2_URL + "?group=" + routeHost;
            // 创建Swagger 资源
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setUrl(serviceUrl); // 设置访问地址
            swaggerResource.setName(routeHost); // 设置名称
            swaggerResource.setSwaggerVersion("v1.0");
            resources.add(swaggerResource);
        }
        return resources;
    }
}
