package com.dangkang.client.api;

import com.dangkang.client.dto.request.requestdto.ApplicationServiceRequestDTO;
import com.dangkang.client.dto.response.resultdto.ApplicationServiceResultDTO;
import com.dangkang.client.dto.response.Response;

/**
 * 应用服务
 */
public interface ApplicationService {
    String TRADE_CODE ="T001";
    String TRADE_DESCRIPTION ="dangkang-ddd应用服务描述信息";

    Response<ApplicationServiceResultDTO> execute(ApplicationServiceRequestDTO applicationServiceRequestDTO);

}
