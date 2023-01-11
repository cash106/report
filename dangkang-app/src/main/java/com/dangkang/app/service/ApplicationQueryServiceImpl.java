package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.dangkang.client.api.ApplicationQueryService;
import com.dangkang.client.dto.ApplicationQueryConditionDTO;
import com.dangkang.client.dto.ApplicationQueryResultDTO;
import com.dangkang.client.dto.result.ApplicationQueryResult;
import com.dangkang.client.dto.validator.PhoneNumberValidator;
import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.exception.ValidationException;
import com.dangkang.domain.model.trade.DomainObject;
import com.dangkang.domain.model.trade.repository.DomainObjectRepository;
import com.dangkang.infrastructure.converter.DomainObjectConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import java.util.List;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * @date 2023/1/11 10:51
 */
@Component
public class ApplicationQueryServiceImpl implements ApplicationQueryService {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationQueryServiceImpl.class);

    @Autowired
    private DomainObjectRepository domainObjectRepository;

    @Override
    public ApplicationQueryResult queryService(ApplicationQueryConditionDTO applicationQueryConditionDTO) {

        ApplicationQueryResult<ApplicationQueryResultDTO> result = new ApplicationQueryResult<>();
        int index = applicationQueryConditionDTO.getIndex();
        int size = applicationQueryConditionDTO.getSize();
        String email = applicationQueryConditionDTO.getEmail();
        String phoneNumber = applicationQueryConditionDTO.getPhoneNumber();

        try{
            //1 查询参数校验
            validateParameter(applicationQueryConditionDTO);
            logger.info("ApplicationQueryServiceImpl.validateParameter输入参数验证成功");

            //2 从数据库获取分页数据
            PageHelper.startPage(index,size);
            List<DomainObject> domainObjects = domainObjectRepository.findList(email,phoneNumber);
            logger.info("ApplicationQueryServiceImpl分页数据查询成功");

            //3 获取到的领域对象列表转换为dto列表
            List<ApplicationQueryResultDTO> applicationQueryResultDtoList = DomainObjectConverter.INSTANCE.toQueryResultDtoList(domainObjects);
            logger.info("ApplicationQueryServiceImpl数据列表转换成功");

            //4 创建分页信息
            PageInfo<ApplicationQueryResultDTO> pageInfo = new PageInfo<>(applicationQueryResultDtoList);
            logger.info("ApplicationQueryServiceImpl分页信息创建成功");

            //5 构建成功返回结果
            result.of(pageInfo);
            result.buildSuccess(TRADE_CODE, TRADE_DESCRIPTION);
            return result;
        }catch (ApplicationException e){
            if(e.getCause()!=null){//应用异常是自定义或转换为ApplicationException，系统异常会内嵌在ApplicationException中
                logger.error(e.getDetailMessage(),e); //系统环境出错
            }else{
                logger.warn(e.getDetailMessage());//业务异常warn
            }
            //5.2 构建失败返回结果
            result.buildFailure(TRADE_CODE, TRADE_DESCRIPTION,e.getErrorCode(),e.getPromptMessage());
            return result;
        }catch (Throwable t){
            logger.error("未处理的异常",t);
            //5.3 构建未处理异常返回
            result.buildUnknownFailure(TRADE_CODE,TRADE_DESCRIPTION,t.getMessage());
            return result;
        }
    }

    private void validateParameter(ApplicationQueryConditionDTO applicationQueryConditionDTO){
        com.baidu.unbiz.fluentvalidator.Result result = FluentValidator.checkAll().failOver()
                .on(applicationQueryConditionDTO,new HibernateSupportedValidator<>().setHiberanteValidator(Validation.buildDefaultValidatorFactory().getValidator()))
                .on(applicationQueryConditionDTO.getPhoneNumber(),new PhoneNumberValidator())
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
