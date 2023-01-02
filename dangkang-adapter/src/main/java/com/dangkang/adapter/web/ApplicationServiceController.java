package com.dangkang.adapter.web;

import com.dangkang.client.api.ApplicationService;
import com.dangkang.client.dto.protocol.request.ApplicationServiceRequest;
import com.dangkang.client.dto.protocol.response.ApplicationServiceResponse;
import com.dangkang.client.dto.result.ApplicationServiceResult;
import com.dangkang.client.dto.valueobject.ApplicationServiceVO;
import com.dangkang.infrastructure.converter.ApplicationServiceDtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anzj
 * @date 2022/12/19 16:51
 */
@RestController
public class ApplicationServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceController.class);

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/hello")
    @ResponseBody
    public ApplicationServiceResponse execute(ApplicationServiceRequest request){

        ApplicationServiceVO applicationServiceVO = ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceVO(request);
        ApplicationServiceResult applicationServiceResult = applicationService.execute(applicationServiceVO);

        return ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceResponse(applicationServiceResult);
    }
}
