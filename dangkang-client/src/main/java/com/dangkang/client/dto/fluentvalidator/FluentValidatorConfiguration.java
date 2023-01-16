package com.dangkang.client.dto.fluentvalidator;

import com.baidu.unbiz.fluentvalidator.interceptor.FluentValidateInterceptor;
import com.dangkang.client.dto.validator.PhoneNumberValidator;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2023/1/12 15:09
 */
@Configuration
public class FluentValidatorConfiguration {

    @Bean
    public FluentValidateInterceptor fluentValidateInterceptor() {
        FluentValidateInterceptor fluentValidateInterceptor = new FluentValidateInterceptor();
        fluentValidateInterceptor.setCallback(validateCallback());
        return fluentValidateInterceptor;
    }
    public FluentValidateCallBack validateCallback() {
        return new FluentValidateCallBack();
    }

/*    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        // 使用BeanNameAutoProxyCreator来创建代理
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        // 设置要创建代理的那些Bean的名字
//        proxyCreator.setBeanNames("*ServiceImpl");
        proxyCreator.setInterceptorNames("fluentValidateInterceptor");
        return proxyCreator;
    }*/

    @Bean
    public PhoneNumberValidator phoneNumberValidator(){
        return new PhoneNumberValidator();
    }

}
