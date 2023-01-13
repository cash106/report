package com.dangkang.client.dto.fluentvalidator;

import com.baidu.unbiz.fluentvalidator.DefaultValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.validator.element.ValidatorElementList;
import com.dangkang.domain.exception.ValidationException;

import java.util.List;

/**
 * @date 2023/1/12 15:02
 */
public class FluentValidateCallBack extends DefaultValidateCallback implements ValidateCallback {

    @Override
    public void onSuccess(ValidatorElementList validatorElementList) {
        super.onSuccess(validatorElementList);
    }

    @Override
    public void onFail(ValidatorElementList validatorElementList, List<ValidationError> errors) {
        StringBuffer stringBuffer = new StringBuffer();
        for(ValidationError error : errors){
            stringBuffer.append(error.getField()).append(":").append(error.getErrorMsg()).append(",");
        }
        throw new ValidationException().setPromptMessage(stringBuffer.toString());
    }

    @Override
    public void onUncaughtException(Validator validator, Exception e, Object target) throws Exception {
        super.onUncaughtException(validator, e, target);
    }

}
