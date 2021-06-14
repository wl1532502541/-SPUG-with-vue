package com.meteor.scorpio.handler.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统一响应注解<br/>
 * 添加注解后，统一响应体才能生效
 * @author MENGZEYUN
 * @date 2020-07-16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface BaseResponse {

}
