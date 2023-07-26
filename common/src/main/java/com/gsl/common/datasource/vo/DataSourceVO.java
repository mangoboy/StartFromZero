package com.gsl.common.datasource.vo;

import lombok.Data;

/**
 * 数据源配置属性
 * @author huangshuo
 * @created 2021/10/5
 **/
@Data
public class DataSourceVO {

    /** 驱动类 **/
    private String driverClassName;

    /** 数据库URL **/
    private String url;

    /** 用户名 **/
    private String username;

    /** 密码 **/
    private String password;

    /** 初始化大小 **/
    private Integer initialSize;

    /** 最小空闲连接 **/
    private Integer minIdle;

    /** 最大连接数 **/
    private Integer maxActive;

    /** 最长等待时间 **/
    private String maxWait;

    /** 空闲连接回收器线程休眠的时间值 **/
    private Long timeBetweenEvictionRunsMillis;

    /** 连接池中的空闲连接保持空闲不被空闲连接回收器线程回收的最小时间值 **/
    private Long minEvictableIdleTimeMillis;

    /** 在把连接返回给调用者之间，SQL查询，用来验证从连接池子取出连接 **/
    private String validationQuery;

    /** 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效 **/
    private Boolean testWhileIdle;

    /** 是否在从池中取出连接前进行检验，做了这个配置会降低性能 **/
    private Boolean testOnBorrow;

    /** 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能 **/
    private Boolean testOnReturn;

    private String filters;
    private String connectionProperties;
}
