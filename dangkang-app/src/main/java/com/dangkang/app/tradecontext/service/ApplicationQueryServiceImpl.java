package com.dangkang.app.tradecontext.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.dangkang.app.annotation.ApplicationService;
import com.dangkang.app.annotation.ExceptionResolver;
import com.dangkang.app.annotation.Validation;
import com.dangkang.client.tradecontext.api.ApplicationQueryService;
import com.dangkang.client.tradecontext.dto.request.ApplicationQueryRequestDTO;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.tradecontext.dto.response.QueryResultDTO;
import com.dangkang.domain.tradecontext.repository.DomainObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @date 2023/1/11 10:51
 */
@Service
public class ApplicationQueryServiceImpl implements ApplicationQueryService {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationQueryServiceImpl.class);

    @Autowired
    private DomainObjectRepository domainObjectRepository;

    @Override
    @ExceptionResolver
    @Validation
    @ApplicationService(ServiceCode = "T002",ServiceName = "当康应用查询服务")
    public MultipleResponse<QueryResultDTO> queryService(@FluentValid(isFailFast = false) ApplicationQueryRequestDTO applicationQueryRequestDTO) {

        MultipleResponse<QueryResultDTO> response = new MultipleResponse<>();
        int index = applicationQueryRequestDTO.getIndex();
        int size = applicationQueryRequestDTO.getSize();
        String email = applicationQueryRequestDTO.getEmail();
        //1 查询参数校验(@FluentValid注解验证)
        //2 从数据库获取数据并分页处理
         Map<String,Object> pages = domainObjectRepository.findPage(index,size,email);
         //3 构建成功返回结果
        response.buildPage( pages);
        response.buildSuccess(SERVICE_CODE, SERVICE_NAME);
        return response;

    }

}
