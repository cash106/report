package com.dangkang.adapter.exception;

import com.dangkang.client.dto.response.AbstractResponse;
import com.dangkang.domain.exception.ApplicationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @date 2023/1/13 14:42
 */
@Aspect
@Order(1)
@Component
public class ExceptionAspect {

    public ExceptionAspect(){
        System.out.println("创建ExceptionAspect的对象成功！！！！");
    }
    public static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Pointcut("@within(ExceptionResolver) && execution(* com.dangkang.adapter.web.*.*(..))")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public AbstractResponse around(ProceedingJoinPoint joinPoint){
        Object methodResponse = null;
        try{
            logger.info("开始执行service方法");
            methodResponse = joinPoint.proceed();
        }catch (Throwable e){
            logger.info("执行service方法出现异常");
            return resolveException(joinPoint,e);
        }
        return (AbstractResponse)methodResponse;
    }

    private AbstractResponse resolveException(ProceedingJoinPoint joinPoint,Throwable t){

        AbstractResponse response = null;
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Class targetClass = joinPoint.getTarget().getClass();

        try {
            String SERVICE_CODE = (String)targetClass.getField("SERVICE_CODE").get(targetClass);
            String SERVICE_DESCRIPTION = (String)targetClass.getField("SERVICE_DESCRIPTION").get(targetClass);

            Class returnType = ms.getReturnType();

            response = (AbstractResponse)returnType.newInstance();

            if(t instanceof ApplicationException){
                //处理应用异常
                ApplicationException ae = (ApplicationException)t;
                if(t.getCause()!=null){//应用异常是自定义或转换为ApplicationException，系统异常会内嵌在ApplicationException中
                    logger.error(ae.getDetailMessage(),t); //系统环境出错
                }else{
                    logger.warn(ae.getPromptMessage());//业务异常warn
                }
                response.buildFailure(SERVICE_CODE,SERVICE_DESCRIPTION,ae.getErrorCode(),ae.getPromptMessage());
            }

            if(t instanceof Exception) {
                //未捕获的其他异常
                response.buildUnknownFailure(SERVICE_CODE,SERVICE_DESCRIPTION,t.getMessage());
            }
            return response;
        } catch (NoSuchFieldException n) {

        } catch (InstantiationException i) {

        } catch (IllegalAccessException iae) {

        }
        return null;
    }
}
