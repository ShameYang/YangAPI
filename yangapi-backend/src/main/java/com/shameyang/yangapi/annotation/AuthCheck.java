package com.shameyang.yangapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ShameYang
 * @date 2024/8/22 18:26
 * @description 权限校验注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 有任何一个角色
     */
    String[] anyRole() default "";

    /**
     * 必须有某个角色
     */
    String mustRole() default "";

}