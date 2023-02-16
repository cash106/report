package com.dangkang.client.examplecontext.api;

import com.dangkang.client.examplecontext.dto.request.ApplicationServiceRequestDTO;
import com.dangkang.client.examplecontext.dto.response.ApplicationServiceResultDTO;
import com.dangkang.client.dto.response.Response;

/**
 * 应用服务
 */
public interface ApplicationService {
    String SERVICE_CODE ="T001";
    String SERVICE_NAME ="dangkang-ddd应用服务描述信息";

    Response<ApplicationServiceResultDTO> execute(ApplicationServiceRequestDTO applicationServiceRequestDTO);

}
