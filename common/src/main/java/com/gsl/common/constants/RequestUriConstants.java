package com.gsl.common.constants;

/**
 * WebMvc常量信息
 *
 * @author taojirun
 */
public class RequestUriConstants {

    /**
     * 不需要拦截地址
     */
    public static final String[] excludeUrls = {"/doc.html/**", "/swagger-ui.html", "/swagger-resources/**",
            "/error", "/webjars/**"};

}
