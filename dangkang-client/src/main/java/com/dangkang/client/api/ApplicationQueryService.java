package com.dangkang.client.api;

import com.dangkang.client.dto.request.ApplicationQueryRequestDTO;
import com.dangkang.client.dto.response.MultipleResponse;
import com.dangkang.client.dto.response.resultdata.QueryResultDataDTO;

/**
 * @date 2023/1/10 18:02
 */
public interface ApplicationQueryService {

    String TRADE_CODE ="T002";
    String TRADE_DESCRIPTION ="dangkang-ddd应用查询类服务描述信息";

    MultipleResponse<QueryResultDataDTO> queryService(ApplicationQueryRequestDTO applicationQueryRequestDTO);
}
