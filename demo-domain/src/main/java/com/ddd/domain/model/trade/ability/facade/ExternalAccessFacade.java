package com.ddd.domain.model.trade.ability.facade;

import com.ddd.domain.model.trade.type.ExternalResult;

/**
 * @author anzj
 * @date 2022/12/23 10:23
 */
public interface ExternalAccessFacade {

    ExternalResult toCall();
}
