package com.ddd.app.service;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.ddd.app.transaction.ApplicationServiceTransaction;
import com.ddd.client.api.ApplicationService;
import com.ddd.client.dto.result.ApplicationServiceResult;
import com.ddd.client.dto.result.Result;
import com.ddd.client.dto.validator.PhoneNumberValidator;
import com.ddd.client.dto.valueobject.ApplicationServiceVO;
import com.ddd.domain.exception.BizException;
import com.ddd.domain.exception.ErrorConstant;
import com.ddd.domain.model.trade.DomainObject;
import com.ddd.domain.model.trade.ability.domainService.DomainService;
import com.ddd.domain.model.trade.ability.factory.DomainObjectFactory;
import com.ddd.domain.model.trade.ability.rule.DomainLogicalRule;
import com.ddd.domain.model.trade.repository.DomainObjectRepository;
import com.ddd.infrastructure.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private DomainObjectFactory domainObjectFactory;
    @Autowired
    private DomainObjectRepository domainObjectRepository;
    @Autowired
    private ApplicationServiceTransaction applicationServiceTransaction;

    @Override
    public ApplicationServiceResult execute(ApplicationServiceVO applicationServiceVO) {
        ApplicationServiceResult applicationServiceResult = new ApplicationServiceResult();
        try {
            //todo 业务逻辑编排
            // 1 输入参数校验 (应用Fluent-Validator + Hibernate-Validator )
            validateParameter(applicationServiceVO);
            logger.info("ApplicationServiceImpl.validateParameter输入参数验证成功");

            // 2.1 调用存储服务(ddd Repository)
            DomainObject domainObject = domainObjectRepository.findAndCheckEmpty(applicationServiceVO.getEmail());
            // 2.2 业务规则验证逻辑(ddd 业务规则封装)
            domainLogicalRule.check(domainObject);
            logger.info("DomainLogicalRule.check领域逻辑规则校验成功");

            // 3.1 领域服务执行(ddd领域服务对象)
            domainService.doService(domainObject);
            logger.info("DomainService.doService领域服务执行成功");

            // 3.2 带事务的领域服务执行
            applicationServiceTransaction.transaction(domainObject);
            logger.info("ApplicationServiceTransaction.transaction事务服务执行成功");

            // 4 构建成功返回信息
            buildResultCode(applicationServiceResult).buildMessageCode(Result.DEFAULT_SUCCESS_CODE);
            return applicationServiceResult;
        } catch (BizException e) {
            if(e.getCause()!=null){//应用异常是自定义或转换为BizException，系统异常会内嵌在BizException中
                logger.error(e.getError().getErrorMessageForOperator(),e); //系统环境出错
            }else{
                logger.warn(e.getError().getErrorMessageForCaller());//业务验证出错
            }

            // 4.1 构建错误返回消息
            buildResultCode(applicationServiceResult).buildMessageCode(e.getError().getErrorCode());//系统编码+交易编码+错误编码
            buildResultMessage(applicationServiceResult).buildBusinessMessage(e.getError().getErrorMessageForCaller());

            return applicationServiceResult;
        }catch (Throwable t){
            logger.error("未处理的异常",t);
            //4.2 构建未处理异常返回消息
            buildResultCode(applicationServiceResult).buildMessageCode(ErrorConstant.ERR_UNHANDLE.getErrorCode());//系统编码+交易编码+错误编码
            buildResultMessage(applicationServiceResult).buildBusinessMessage(t.getMessage());
            return applicationServiceResult;
        }
    }

    private void validateParameter(ApplicationServiceVO applicationServiceVO){
        com.baidu.unbiz.fluentvalidator.Result result = FluentValidator.checkAll().failOver()
                .on(applicationServiceVO.getPhoneNumber(),new PhoneNumberValidator())
                .doValidate().result(toSimple());
        if(!result.isSuccess()){
            StringBuffer stringBuffer = new StringBuffer();
            for(String error : result.getErrors()){
                stringBuffer.append(error);
            }
            throw BizException.buildBizException (ErrorConstant.ERR_VALIDATION_PARAMETER.buildErrorMessageForCaller(stringBuffer.toString()));
        }
    }

    private ApplicationServiceResult buildResultCode(ApplicationServiceResult applicationServiceResult){
        applicationServiceResult.buildSystemCode(Constant.SYSTEM_CODE).buildTradeCode(Constant.DDD_APPLICATION_SERVICE);
        return applicationServiceResult;
    }

    private ApplicationServiceResult buildResultMessage(ApplicationServiceResult applicationServiceResult){
        applicationServiceResult.buildSystemDescription(Constant.SYSTEM_DESCRIPTION).buildTradeDescription(Constant.DDD_APPLICATION_SERVICE_DESCRIPTION);
        return applicationServiceResult;
    }
}
