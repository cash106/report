package com.dangkang.client.api;

import com.dangkang.client.dto.result.ApplicationServiceResult;
import com.dangkang.client.dto.valueobject.ApplicationServiceVO;

/**
 * 应用服务
 */
public interface ApplicationService {
    String TRADE_CODE ="T001";
    String TRADE_DESCRIPTION ="dangkang-ddd应用服务描述信息";

    ApplicationServiceResult execute(ApplicationServiceVO applicationServiceVO);

}
