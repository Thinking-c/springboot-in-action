package com.chargedot.malfunction.annotation;

import java.lang.annotation.*;

/**
 * @Author：caoj
 * @Description： read dataSource annotation
 * @Data：Created in 2018/1/4
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ReadDataSource {

}
