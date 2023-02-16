package com.dangkang.client.validator;

import com.baidu.unbiz.fluentvalidator.interceptor.FluentValidateInterceptor;
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

}
