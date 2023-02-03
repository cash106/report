package com.dangkang.client.tradecontext.api;

import com.dangkang.client.tradecontext.dto.request.ApplicationServiceRequestDTO;
import com.dangkang.client.tradecontext.dto.response.ApplicationServiceResultDTO;
import com.dangkang.client.dto.response.Response;

/**
 * 应用服务
 */
public interface ApplicationService {
    String SERVICE_CODE ="T001";
    String SERVICE_NAME ="dangkang-ddd应用服务描述信息";

    Response<ApplicationServiceResultDTO> execute(ApplicationServiceRequestDTO applicationServiceRequestDTO);

}
