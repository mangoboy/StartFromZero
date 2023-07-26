package com.gsl.common.datasource;

import com.gsl.common.datasource.aop.DatabaseAspect;
import com.gsl.common.datasource.config.DataSourceConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启动多数据源注解类
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DataSourceConfig.class, DatabaseAspect.class})
public @interface EnableDruidDataSource {
}
