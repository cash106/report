package com.dangkang.app.exception;

import com.baidu.unbiz.fluentvalidator.interceptor.FluentValidateInterceptor;
import com.dangkang.client.dto.response.AbstractResponse;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.dto.response.Response;
import com.dangkang.domain.exception.ApplicationException;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @date 2023/1/13 14:42
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class ExceptionAspect {

    @Autowired
    private FluentValidateInterceptor fluentValidateInterceptor;

    public ExceptionAspect(){
    }
    public static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

//    @Pointcut("execution(* com.dangkang.app.service.*.*(..))")
    @Pointcut(value="@annotation(com.dangkang.app.exception.ExceptionResolver)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object methodResponse = null;
        try{
            invokeValidate(joinPoint);

            methodResponse = joinPoint.proceed();
        }catch (Throwable e){
            if(logger.isDebugEnabled()){
                logger.debug("around exception",e);
            }
            return resolveException(joinPoint,e);
        }
        return methodResponse;
    }

    private Object resolveException(ProceedingJoinPoint joinPoint,Throwable t)  {
            AbstractResponse response;
            MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            Class returnType = ms.getReturnType();
            if(returnType == Response.class){
                response = new Response<>();
            }else {
                response = new MultipleResponse<>();
            }

            Class targetClass = joinPoint.getTarget().getClass();
            String SERVICE_CODE = "";
            String SERVICE_DESCRIPTION = "";
            try {
                SERVICE_CODE = (String) targetClass.getField("SERVICE_CODE").get(targetClass);
                SERVICE_DESCRIPTION = (String) targetClass.getField("SERVICE_DESCRIPTION").get(targetClass);
            }catch (Exception e){
                //...找不到字段不做处理：默认空字符串
                logger.warn("服务接口未定义SERVICE_CODE和SERVICE_DESCRIPTION属性");
            }
            if (t instanceof ApplicationException) {
                //处理应用异常
                ApplicationException ae = (ApplicationException) t;
                if (t.getCause() != null) {//应用异常是自定义或转换为ApplicationException，系统异常会内嵌在ApplicationException中
                    logger.error(ae.getDetailMessage(), t); //系统环境出错

                } else {
                    logger.warn(ae.getPromptMessage());//业务异常warn
                }
                response.buildFailure(SERVICE_CODE, SERVICE_DESCRIPTION, ae.getErrorCode(), ae.getPromptMessage());
            } else {
                //未捕获的其他异常
                response.buildUnknownFailure(SERVICE_CODE, SERVICE_DESCRIPTION, t.getMessage());
            }
            return response;
    }

    private void invokeValidate(JoinPoint joinPoint) throws Throwable{
        MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint)joinPoint;
        ProxyMethodInvocation proxyMethodInvocation;
            Field methodInvocation = MethodInvocationProceedingJoinPoint.class.getDeclaredField("methodInvocation");
            // 避免出现不可访问异常
            methodInvocation.setAccessible(true);
            proxyMethodInvocation = (ProxyMethodInvocation)methodInvocation.get(methodInvocationProceedingJoinPoint);
            fluentValidateInterceptor.invoke(proxyMethodInvocation);
    }
}
