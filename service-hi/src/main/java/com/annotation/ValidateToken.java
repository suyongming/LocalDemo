package com.annotation;

import java.lang.annotation.*;


/**
 * 标注该注解的方法需要验证身份.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateToken {

    /**
     * 接口详细描述.
     */
    String description() default "";
}
