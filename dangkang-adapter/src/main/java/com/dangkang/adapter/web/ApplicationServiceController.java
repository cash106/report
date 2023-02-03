package com.dangkang.adapter.web;

import com.dangkang.client.tradecontext.api.ApplicationQueryService;
import com.dangkang.client.tradecontext.api.ApplicationService;
import com.dangkang.client.tradecontext.dto.request.ApplicationQueryRequestDTO;
import com.dangkang.client.tradecontext.dto.request.ApplicationServiceRequestDTO;
import com.dangkang.client.tradecontext.dto.response.ApplicationServiceResultDTO;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.tradecontext.dto.response.QueryResultDTO;
import com.dangkang.client.dto.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceController.class);

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationQueryService applicationQueryService;

    @PostMapping("/hello")
    @ResponseBody
    public Response<ApplicationServiceResultDTO> execute(@RequestBody ApplicationServiceRequestDTO applicationServiceRequestDTO){

//        logger.info("ApplicationService请求参数 request = [{}]",applicationServiceRequestDTO);
        Response<ApplicationServiceResultDTO> response = applicationService.execute(applicationServiceRequestDTO);
//        logger.info("ApplicationService响应参数 response = [{}]",response);
        return response;
    }

    @PostMapping("/query")
    @ResponseBody
    public MultipleResponse queryService(ApplicationQueryRequestDTO applicationQueryRequest){
        logger.info("ApplicationQueryService请求参数 request = [{}]",applicationQueryRequest);
        MultipleResponse<QueryResultDTO> response = applicationQueryService.queryService(applicationQueryRequest);
        logger.info("ApplicationQueryService响应参数 response = [{}]",response);
        return response;

    }


}
