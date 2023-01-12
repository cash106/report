package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.baidu.unbiz.fluentvalidator.jsr303.HibernateSupportedValidator;
import com.dangkang.client.api.ApplicationQueryService;
import com.dangkang.client.dto.request.requestdto.ApplicationQueryRequestDTO;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.dto.response.resultdto.QueryResultDTO;
import com.dangkang.infrastructure.validator.PhoneNumberValidator;
import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.exception.ValidationException;
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
    public MultipleResponse<QueryResultDTO> queryService(@FluentValid ApplicationQueryRequestDTO applicationQueryRequestDTO) {

        MultipleResponse<QueryResultDTO> response = new MultipleResponse<>();

        int index = applicationQueryRequestDTO.getIndex();
        int size = applicationQueryRequestDTO.getSize();
        String email = applicationQueryRequestDTO.getEmail();

        try{
            //1 查询参数校验(@FluentValid注解验证)

            //2 从数据库获取数据并分页处理
            Map<String,Object> pages = domainObjectRepository.findPage(index,size,email);

            //3 构建成功返回结果
            response.setTotalSize((long)pages.get("totalSize"));
            response.setTotalPages((int)pages.get("totalPages"));
            response.setCurrentIndex((int)pages.get("currentIndex"));
            response.setPageSize((int)pages.get("pageSize"));
            response.setData((List<QueryResultDTO>) pages.get("dataList"));
            response.buildSuccess(TRADE_CODE, TRADE_DESCRIPTION);
            return response;
        }catch (ApplicationException e){
            //3.1 构建失败返回结果
            response.buildFailure(TRADE_CODE, TRADE_DESCRIPTION,e);
            return response;
        }catch (Throwable t){
            //3.2 构建未处理异常返回
            response.buildUnknownFailure(TRADE_CODE,TRADE_DESCRIPTION,t);
            return response;
        }
    }
}
