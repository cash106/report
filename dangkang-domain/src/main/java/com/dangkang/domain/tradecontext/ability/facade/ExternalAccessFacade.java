package com.dangkang.domain.tradecontext.ability.facade;

import com.dangkang.domain.tradecontext.type.CallRequestDto;
import com.dangkang.domain.tradecontext.type.CallResult;
import com.dangkang.domain.tradecontext.type.QueryRequestDto;
import com.dangkang.domain.tradecontext.type.QueryResult;

/**
 * @date 2022/12/23 10:23
 */
public interface ExternalAccessFacade {

    String ERR_CALL_RETURN_UNKNOWN_CODE = "R001";
    String ERR_CALL_RETURN_UNKNOWN_MESSAGE = "call方法执行结果未知";

    CallResult call(CallRequestDto callRequestDto);

    QueryResult query(QueryRequestDto queryRequestDto);
}
