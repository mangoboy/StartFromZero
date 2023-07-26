package com.gsl.common.datasource.aop;

import com.gsl.common.datasource.TargetDataSource;
import com.gsl.common.datasource.holder.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 动态数据源切面类
 * @author huangshuo
 * @created 2023/04/07
 **/
@Slf4j
public class DynamicDataSourceAspect {

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.gsl.common.datasource.TargetDataSource)")
    protected void pointcut() {}

    @Before("pointcut()")
    public void beforePointcut(JoinPoint joinPoint) {

        String dataSourceName = this.determineDataSource(joinPoint);
        if (StringUtils.isNotEmpty(dataSourceName)) {
            DataSourceContextHolder.setDataSourceType(dataSourceName);
            log.info("DataSource Name: {}", dataSourceName);
        }
    }

    @After("pointcut()")
    public void afterPointcut() {
        String dataSourceType =  DataSourceContextHolder.clearDataSourceType();
        log.info("method end, DataSource Name clear: {}", dataSourceType);
    }

    public String determineDataSource(JoinPoint joinPoint) {
        String targetMethod = joinPoint.getSignature().getName();
        Class<?> targetClass = joinPoint.getSignature().getDeclaringType();
        Object[] args = joinPoint.getArgs();
        String dataSourceName = this.resolveDataSourceNameFromClass(targetClass);
        String dataSourceForTargetMethod = this.resolveDataSourceFromMethod(targetClass, targetMethod, args);
        return this.determinateDataSource(dataSourceName, dataSourceForTargetMethod);
    }

    private String resolveDataSourceNameFromClass(Class<?> targetClass) {
        TargetDataSource classAnnotation = targetClass.getAnnotation(TargetDataSource.class);
        return classAnnotation == null ? null : this.resolveDataSourceName(classAnnotation);
    }

    private String resolveDataSourceName(TargetDataSource targetDataSource) {
        return targetDataSource == null ? null : targetDataSource.value();
    }

    private String resolveDataSourceFromMethod(Class<?> targetClass, String methodName, Object[] args) {
        Method method = findUniqueMethod(targetClass, methodName);
        if (method != null) {
            TargetDataSource targetDataSourceMethodAnnotation = method.getAnnotation(TargetDataSource.class);
            return targetDataSourceMethodAnnotation == null ? this.resolveDataSourceNameFormParam(method, args) : this.resolveDataSourceName(targetDataSourceMethodAnnotation);
        } else {
            return null;
        }
    }

    private String resolveDataSourceNameFormParam(Method method, Object[] args) {
        Parameter[] parameters = method.getParameters();
        if (parameters.length != 0 || args.length != 0) {
            for (int i = 0; i < parameters.length; ++i) {
                Parameter parameter = parameters[i];
                TargetDataSource targetDataSource = parameter.getAnnotation(TargetDataSource.class);
                if (targetDataSource != null) {
                    return String.valueOf(args[i]);
                }
            }

        }
        return null;
    }

    private static Method findUniqueMethod(Class<?> clazz, String methodName) {
        for (Class<?> searchType = clazz; searchType != null; searchType = searchType.getSuperclass()) {
            Method[] methods = searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    return method;
                }
            }
        }
        return null;
    }

    private String determinateDataSource(String classDS, String methodDS) {
        return methodDS == null ? classDS : methodDS;
    }
}
