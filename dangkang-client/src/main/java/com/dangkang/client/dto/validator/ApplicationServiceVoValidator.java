package com.dangkang.client.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.client.dto.valueobject.ApplicationServiceVO;

/**
 * 入参校验器示例
 */
public class ApplicationServiceVoValidator extends ValidatorHandler<ApplicationServiceVO> implements Validator<ApplicationServiceVO> {

    @Override
    public boolean validate(ValidatorContext context, ApplicationServiceVO applicationServiceVO) {
        if(applicationServiceVO.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
