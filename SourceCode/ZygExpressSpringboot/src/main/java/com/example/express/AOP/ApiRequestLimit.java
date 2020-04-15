package com.example.express.AOP;

import com.example.express.enums.RateLimitEnum;

import java.lang.annotation.*;

/**
 * 注解应用范围，编译范围
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRequestLimit {
    RateLimitEnum limit() default RateLimitEnum.RRLimit_5_1;
}