package com.ddd.adapter.web;

import com.ddd.client.api.ApplicationService;
import com.ddd.client.dto.protocol.request.ApplicationServiceRequest;
import com.ddd.client.dto.protocol.response.ApplicationServiceResponse;
import com.ddd.client.dto.result.ApplicationServiceResult;
import com.ddd.client.dto.valueobject.ApplicationServiceVO;
import com.ddd.infrastructure.converter.ApplicationServiceDtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    @ResponseBody
    public ApplicationServiceResponse execute(ApplicationServiceRequest request){

        ApplicationServiceVO applicationServiceVO = ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceVO(request);
        ApplicationServiceResult applicationServiceResult = applicationService.execute(applicationServiceVO);

        return ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceResponse(applicationServiceResult);
    }
}
