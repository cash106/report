package com.dangkang.app.exception;

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
    }
    public static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Pointcut(value="@annotation(com.dangkang.adapter.exception.ExceptionResolver)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public AbstractResponse around(ProceedingJoinPoint joinPoint){
        AbstractResponse methodResponse = null;
        try{
            methodResponse = (AbstractResponse)joinPoint.proceed();
        }catch (Throwable e){
            if(logger.isDebugEnabled()){
                logger.debug("around exception",e);
            }
            return resolveException(joinPoint,methodResponse,e);
        }
        return methodResponse;
    }

    private AbstractResponse resolveException(ProceedingJoinPoint joinPoint,AbstractResponse response,Throwable t)  {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Class targetClass = joinPoint.getTarget().getClass();
        String SERVICE_CODE ="unknow service code";
        String SERVICE_DESCRIPTION="unknow service description";
        try {
            SERVICE_CODE = (String)targetClass.getField("SERVICE_CODE").get(targetClass);
            SERVICE_DESCRIPTION = (String)targetClass.getField("SERVICE_DESCRIPTION").get(targetClass);
        } catch (NoSuchFieldException e) {
            logger.warn("未找到SERVICE_CODE或SERVICE_DESCRIPTION的类变量定义", e);
        }  catch (SecurityException e) {
                logger.warn("安全受限",e);
        }catch(IllegalAccessException e){
            logger.warn("非法访问",e);
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
        }
       else {
            //未捕获的其他异常
            response.buildUnknownFailure(SERVICE_CODE, SERVICE_DESCRIPTION, t.getMessage());
        }
        return response;
    }
}
