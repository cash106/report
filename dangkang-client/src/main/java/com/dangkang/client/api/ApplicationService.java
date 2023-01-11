package com.dangkang.client.api;

import com.dangkang.client.dto.request.ApplicationServiceRequestDTO;
import com.dangkang.client.dto.response.resultdata.ApplicationServiceResultDataDTO;
import com.dangkang.client.dto.response.SingleResponse;

/**
 * 应用服务
 */
public interface ApplicationService {
    String TRADE_CODE ="T001";
    String TRADE_DESCRIPTION ="dangkang-ddd应用服务描述信息";

    SingleResponse<ApplicationServiceResultDataDTO> execute(ApplicationServiceRequestDTO applicationServiceRequestDTO);

}
