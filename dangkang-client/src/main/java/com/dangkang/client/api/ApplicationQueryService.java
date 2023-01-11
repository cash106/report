package com.dangkang.client.api;

import com.dangkang.client.dto.ApplicationQueryConditionDTO;
import com.dangkang.client.dto.result.ApplicationQueryResult;

/**
 * @date 2023/1/10 18:02
 */
public interface ApplicationQueryService {

    String TRADE_CODE ="T002";
    String TRADE_DESCRIPTION ="dangkang-ddd应用查询类服务描述信息";

    ApplicationQueryResult queryService(ApplicationQueryConditionDTO applicationQueryConditionDTO);
}
