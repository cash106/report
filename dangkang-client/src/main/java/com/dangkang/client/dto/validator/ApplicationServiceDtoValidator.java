package com.dangkang.client.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.dangkang.client.dto.request.requestdto.ApplicationServiceRequestDTO;

/**
 * 入参校验器示例
 */
public class ApplicationServiceDtoValidator extends ValidatorHandler<ApplicationServiceRequestDTO> implements Validator<ApplicationServiceRequestDTO> {

    @Override
    public boolean validate(ValidatorContext context, ApplicationServiceRequestDTO applicationServiceRequestDTO) {
        if(applicationServiceRequestDTO.getEmail() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
