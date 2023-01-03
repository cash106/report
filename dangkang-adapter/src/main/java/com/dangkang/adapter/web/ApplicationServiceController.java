package com.dangkang.adapter.web;

import com.dangkang.client.api.ApplicationService;
import com.dangkang.client.dto.ApplicationServiceDTO;
import com.dangkang.client.dto.protocol.request.ApplicationServiceRequest;
import com.dangkang.client.dto.protocol.response.ApplicationServiceResponse;
import com.dangkang.client.dto.result.ApplicationServiceResult;
import com.dangkang.infrastructure.converter.ApplicationServiceDtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ApplicationServiceResponse execute(@RequestBody ApplicationServiceRequest request){

        ApplicationServiceDTO applicationServiceDTO = ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceVO(request);
        ApplicationServiceResult applicationServiceResult = applicationService.execute(applicationServiceDTO);

        return ApplicationServiceDtoConverter.INSTANCE.toApplicationServiceResponse(applicationServiceResult);
    }
}
