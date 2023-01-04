package com.dangkang.domain.model.trade.ability.facade;

import com.dangkang.domain.model.trade.type.CallRequestDto;
import com.dangkang.domain.model.trade.type.CallResult;
import com.dangkang.domain.model.trade.type.QueryRequestDto;
import com.dangkang.domain.model.trade.type.QueryResult;

/**
 * @date 2022/12/23 10:23
 */
public interface ExternalAccessFacade {

    String ERR_CALL_RETURN_UNKNOWN_CODE = "R001";
    String ERR_CALL_RETURN_UNKNOWN_MESSAGE = "call方法执行结果未知";

    CallResult call(CallRequestDto callRequestDto);

    QueryResult query(QueryRequestDto queryRequestDto);
}
