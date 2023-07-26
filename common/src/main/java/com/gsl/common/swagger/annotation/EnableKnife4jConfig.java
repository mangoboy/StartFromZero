package com.gsl.common.swagger.annotation;

import com.gsl.common.swagger.config.Knife4jConfig;
import com.gsl.common.swagger.porp.Knife4jProp;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({Knife4jConfig.class, Knife4jProp.class})
public @interface EnableKnife4jConfig {
}
