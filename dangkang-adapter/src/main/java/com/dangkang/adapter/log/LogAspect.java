package com.dangkang.adapter.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @date 2023/1/16 9:42
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.dangkang.adapter.web.*.*(..))")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        MethodSignature method = (MethodSignature)joinPoint.getSignature();
        String name = method.getName();
        logger.info("服务"+className+"的方法"+name+"请求参数request := [{}]",joinPoint.getArgs());
    }

    @AfterReturning(returning = "response",pointcut = "pointcut()")
    public void afterReturning(JoinPoint joinPoint, Object response){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        MethodSignature method = (MethodSignature)joinPoint.getSignature();
        String name = method.getName();

        logger.info("服务"+className+"的方法"+name+"响应参数response := [{}]",response);
    }

}
