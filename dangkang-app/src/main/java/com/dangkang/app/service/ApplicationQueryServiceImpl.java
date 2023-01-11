package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.dangkang.client.api.ApplicationQueryService;
import com.dangkang.client.dto.request.ApplicationQueryRequestDTO;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.dto.response.resultdata.QueryResultDataDTO;
import com.dangkang.client.dto.request.validator.PhoneNumberValidator;
import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.exception.ValidationException;
import com.dangkang.domain.model.trade.DomainObject;
import com.dangkang.domain.model.trade.repository.DomainObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import java.util.List;
import java.util.Map;

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
    public MultipleResponse<QueryResultDataDTO> queryService(ApplicationQueryRequestDTO applicationQueryRequestDTO) {

        MultipleResponse<QueryResultDataDTO> response = new MultipleResponse<>();

        int index = applicationQueryRequestDTO.getIndex();
        int size = applicationQueryRequestDTO.getSize();
        String email = applicationQueryRequestDTO.getEmail();

        try{
            //1 查询参数校验
            validateParameter(applicationQueryRequestDTO);
            logger.info("ApplicationQueryServiceImpl.validateParameter输入参数验证成功");

            //2 从数据库获取分页数据

            Map<String,Object> pages = domainObjectRepository.findPage(index,size,email);

            //4 构建成功返回结果
            response.setTotalSize((int)pages.get("totalSize"));
            response.buildSuccess(TRADE_CODE, TRADE_DESCRIPTION);
            return response;
        }catch (ApplicationException e){
            if(e.getCause()!=null){//应用异常是自定义或转换为ApplicationException，系统异常会内嵌在ApplicationException中
                logger.error(e.getDetailMessage(),e); //系统环境出错
            }else{
                logger.warn(e.getDetailMessage());//业务异常warn
            }
            //5.2 构建失败返回结果
            response.buildFailure(TRADE_CODE, TRADE_DESCRIPTION,e.getErrorCode(),e.getPromptMessage());
            return response;
        }catch (Throwable t){
            logger.error("未处理的异常",t);
            //5.3 构建未处理异常返回
            response.buildUnknownFailure(TRADE_CODE,TRADE_DESCRIPTION,t.getMessage());
            return response;
        }
    }

    private void validateParameter(ApplicationQueryRequestDTO applicationQueryRequestDTO){
        com.baidu.unbiz.fluentvalidator.Result result = FluentValidator.checkAll().failOver()
                .on(applicationQueryRequestDTO,new HibernateSupportedValidator<>().setHiberanteValidator(Validation.buildDefaultValidatorFactory().getValidator()))
                .on(applicationQueryRequestDTO.getPhoneNumber(),new PhoneNumberValidator())
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
