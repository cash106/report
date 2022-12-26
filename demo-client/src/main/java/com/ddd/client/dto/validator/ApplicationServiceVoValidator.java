package com.ddd.client.dto.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.ddd.client.dto.valueobject.ApplicationServiceVO;

/**
 * @author anzj
 * @date 2022/12/23 10:17
 */
public class ApplicationServiceVoValidator extends ValidatorHandler<ApplicationServiceVO> implements Validator<ApplicationServiceVO> {

    @Override
    public boolean validate(ValidatorContext context, ApplicationServiceVO applicationServiceVO) {
        if(applicationServiceVO.getTodo() == null){
            context.addErrorMsg("不能为空");
            return false;
        }
        return true;
    }
}
