package com.gsl.common.constants;

/**
 * 缓存常量信息
 *
 * @author taojirun
 */
public class CacheConstants {

    /**
     * 视频平台缓存前缀
     */
    public final static String VP_CACHE_PREFIX = "vp:";

    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 720;

    /**
     * 缓存刷新时间，默认120（分钟）
     */
    public final static long REFRESH_TIME = 120;

    /**
     * 权限缓存前缀
     */
    public final static String LOGIN_TOKEN_KEY = "login_tokens:";

}
