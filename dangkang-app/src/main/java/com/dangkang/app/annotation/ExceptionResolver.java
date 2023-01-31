package com.dangkang.app.annotation;

import java.lang.annotation.*;

/**
 * @date 2023/1/13 14:39
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExceptionResolver {

    boolean isValidate() default true;

}
