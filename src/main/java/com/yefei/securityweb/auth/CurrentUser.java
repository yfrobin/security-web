package com.yefei.securityweb.auth;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author: yefei
 * @Date: create in 2019-11-25
 * @Desc:
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    boolean required() default true;
}
