package com.gsl.common.datasource.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author huangshuo
 * @created 2021/7/10
 **/
@Component
@Aspect
@Order(-1)
public class DatabaseAspect extends DynamicDataSourceAspect {

    @Pointcut("execution(* com.gsl..service..*.*(..))")
    @Override
    protected void pointcut() {
        super.pointcut();
    }
}
