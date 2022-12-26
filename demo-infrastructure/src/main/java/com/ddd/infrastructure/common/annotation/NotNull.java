package com.ddd.infrastructure.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author anzj
 * @date 2022/12/21 15:52
 */
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
public @interface NotNull {
}
