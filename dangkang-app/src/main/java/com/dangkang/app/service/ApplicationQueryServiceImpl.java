package com.dangkang.app.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.client.api.ApplicationQueryService;
import com.dangkang.client.dto.request.requestdto.ApplicationQueryRequestDTO;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.dto.response.resultdto.QueryResultDTO;
import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.model.trade.repository.DomainObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

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
            response.buildPage( pages);
            response.buildSuccess(SERVICE_CODE, SERVICE_DESCRIPTION);
        }catch (ApplicationException e){
            //3.1 构建失败返回结果
            response.buildFailure(SERVICE_CODE, SERVICE_DESCRIPTION,e);
        }catch (Throwable t){
            //3.2 构建未处理异常返回
            response.buildUnknownFailure(SERVICE_CODE, SERVICE_DESCRIPTION,t);
        }
        return response;
    }
}
