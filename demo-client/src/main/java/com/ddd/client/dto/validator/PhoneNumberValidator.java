package com.ddd.client.dto.validator;


import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author anzj
 * @date 2022/12/19 10:25
 */
public class PhoneNumberValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String s) {
        if("0".equals(s.substring(0,1)) || s.length() != 11){
            context.addError(ValidationError.create("手机号码不符合规则")
                    .setField("phoneNumber")
                    .setInvalidValue(s));
            return false;
        }
        return true;
    }
}
