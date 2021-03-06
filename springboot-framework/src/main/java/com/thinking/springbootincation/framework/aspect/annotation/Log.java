package com.thinking.springbootincation.framework.aspect.annotation;

import com.thinking.springbootincation.common.constant.OperatorType;

import java.lang.annotation.*;

/**
 * @Author：caoj
 * @Description： 自定义操作日志记录注解
 * @Date：Created in 2018/7/26
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    String action() default "";

    /**
     * 渠道
     */
    String channel() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}
