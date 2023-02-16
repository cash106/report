package com.dangkang.infrastructure.logmasking.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @date 2022/12/21 15:52
 */
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
public @interface NotNull {
}
