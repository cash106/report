package com.dangkang.client.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.client.dto.ApplicationServiceDTO;

/**
 * 入参校验器示例
 */
public class ApplicationServiceDtoValidator extends ValidatorHandler<ApplicationServiceDTO> implements Validator<ApplicationServiceDTO> {

    @Override
    public boolean validate(ValidatorContext context, ApplicationServiceDTO applicationServiceDTO) {
        if(applicationServiceDTO.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
