package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.dangkang.app.transaction.ApplicationServiceTransaction;
import com.dangkang.client.api.ApplicationService;
import com.dangkang.client.dto.request.ApplicationServiceRequestDTO;
import com.dangkang.client.dto.response.resultdata.ApplicationServiceResultDataDTO;
import com.dangkang.client.dto.response.SingleResponse;
import com.dangkang.client.dto.request.validator.PhoneNumberValidator;
import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.exception.ValidationException;
import com.dangkang.domain.model.trade.DomainObject;
import com.dangkang.domain.model.trade.ability.domainService.DomainService;
import com.dangkang.domain.model.trade.ability.rule.DomainLogicalRule;
import com.dangkang.domain.model.trade.repository.DomainObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * 应用服务层:1、逻辑错误异常等统一处理  2、业务主逻辑步骤
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainLogicalRule domainLogicalRule;
    @Autowired
    private DomainObjectRepository domainObjectRepository;
    @Autowired
    private ApplicationServiceTransaction applicationServiceTransaction;

    @Override
    public SingleResponse<ApplicationServiceResultDataDTO> execute(ApplicationServiceRequestDTO applicationServiceRequestDTO) {
        SingleResponse<ApplicationServiceResultDataDTO> response = new SingleResponse<>();
        ApplicationServiceResultDataDTO applicationServiceResultDataDTO = new ApplicationServiceResultDataDTO();
        try {
            //todo 业务逻辑编排
            // 1 输入参数校验 (应用Fluent-Validator + Hibernate-Validator )
            validateParameter(applicationServiceRequestDTO);
            logger.info("ApplicationServiceImpl.validateParameter输入参数验证成功");

            // 2.1 调用存储服务(ddd Repository)
            DomainObject domainObject = domainObjectRepository.findAndCheckEmpty(applicationServiceRequestDTO.getPhoneNumber());
            // 2.2 业务规则验证逻辑(ddd 业务规则封装)
            domainLogicalRule.check(domainObject);
            logger.info("DomainLogicalRule.check领域逻辑规则校验成功");

            // 3.1 领域服务执行(ddd领域服务对象)
            domainService.doService(domainObject);
            logger.info("DomainService.doService领域服务执行成功");

            // 3.2 带事务的领域服务执行
            applicationServiceTransaction.transaction(domainObject);
            logger.info("ApplicationServiceTransaction.transaction事务服务执行成功");

            // 4 构建成功返回
            response.buildSuccess(TRADE_CODE, TRADE_DESCRIPTION);
            response.setData(applicationServiceResultDataDTO);
            return response;
        } catch (ApplicationException e) {
            if(e.getCause()!=null){//应用异常是自定义或转换为ApplicationException，系统异常会内嵌在ApplicationException中
                logger.error(e.getDetailMessage(),e); //系统环境出错
            }else{
                logger.warn(e.getDetailMessage());//业务异常warn
            }

            // 4.1 构建错误返回
            response.buildFailure(TRADE_CODE, TRADE_DESCRIPTION,e.getErrorCode(),e.getPromptMessage());
            return response;
        }catch (Throwable t){
            logger.error("未处理的异常",t);
            //4.2 构建未处理异常返回
            response.buildUnknownFailure(TRADE_CODE,TRADE_DESCRIPTION,t.getMessage());
            return response;
        }
    }

    private void validateParameter(ApplicationServiceRequestDTO applicationServiceRequestDTO){
        Result result = FluentValidator.checkAll().failOver()
                .on(applicationServiceRequestDTO,new HibernateSupportedValidator<>().setHiberanteValidator(Validation.buildDefaultValidatorFactory().getValidator()))
                .on(applicationServiceRequestDTO.getPhoneNumber(),new PhoneNumberValidator())
                .doValidate().result(toSimple());
        if(!result.isSuccess()){
            StringBuffer stringBuffer = new StringBuffer();
            for(String error : result.getErrors()){
                stringBuffer.append(error);
            }
            throw new ValidationException().setPromptMessage(stringBuffer.toString());
        }
    }

}
