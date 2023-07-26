package com.gsl.common.result;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({ResponseResultAutoConfiguration.class})
public @interface EnableResponseResult {
}
