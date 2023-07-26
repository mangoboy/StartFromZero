package com.gsl.common.context;

import com.gsl.common.constants.IdmUserInfoConstants;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 获取当前线程变量中的 用户id、用户名称等信息
 * 注意： 必须在网关通过请求头的方法传入，同时在HeaderInterceptor拦截器设置值。 否则这里无法获取
 *
 * @author taojirun
 */
public class UserInfoContextHolder {

    /**
     * 用户ID字段
     */
    public static final String IDM_USER_ACCOUNT = IdmUserInfoConstants.USER_ACCOUNT;

    /**
     * 用户名字段
     */
    public static final String IDM_USERNAME = IdmUserInfoConstants.USER_NAME;

    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = getLocalMap();
        map.put(key, value == null ? StringUtils.EMPTY : value);
    }

    public static String get(String key) {
        Map<String, Object> map = getLocalMap();
        return (String) (map.getOrDefault(key, StringUtils.EMPTY));
    }

    public static Map<String, Object> getLocalMap() {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new ConcurrentHashMap<String, Object>();
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void setLocalMap(Map<String, Object> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    public static String getUserAccount() {
        return get(IDM_USER_ACCOUNT);
    }

    public static void setUserAccount(String account) {
        set(IDM_USER_ACCOUNT, account);
    }

    public static String getUserName() {
        return get(IDM_USERNAME);
    }

    public static void setUserName(String username) {
        set(IDM_USERNAME, username);
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
