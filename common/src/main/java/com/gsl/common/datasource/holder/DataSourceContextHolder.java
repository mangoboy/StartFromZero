package com.gsl.common.datasource.holder;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 数据源上下文拥有者
 * @author huangshuo
 * @created 2023/04/07
 **/
@Slf4j
public class DataSourceContextHolder {

    /** 数据源全局变量 **/
    public final static ThreadLocal<Stack<String>> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param dbType 数据源类型
     */
    public static void setDataSourceType(String dbType) {

        log.info("【设置数据源】数据源类型：" + dbType);
        Stack<String> stacks = contextHolder.get();
        if(stacks == null){
            stacks = new Stack<>();
        }
        stacks.push(dbType);
        contextHolder.set(stacks);
    }

    /**
     * 获取数据源类型
     * @return 数据源类型
     */
    public static String getDataSourceType() {

        Stack<String> stacks = contextHolder.get();
        if(stacks == null || stacks.isEmpty()){
            return null;
        }
        String dbType = stacks.peek();
        log.info("【获取数据源】数据源类型：" + dbType);
        return dbType;
    }

    /**
     * 清除顶部数据源
     * @return 数据源类型
     */
    public static String clearDataSourceType() {

        Stack<String> stacks = contextHolder.get();
        if(stacks == null || stacks.isEmpty()) {
            contextHolder.remove();
            return null;
        } else {
            String dbType = stacks.pop();
            if (stacks.size() == 0) {
                contextHolder.remove();
            } else {
                contextHolder.set(stacks);
            }
            log.info("【移除数据源】数据源类型：" + dbType);
            return dbType;
        }
    }
}
