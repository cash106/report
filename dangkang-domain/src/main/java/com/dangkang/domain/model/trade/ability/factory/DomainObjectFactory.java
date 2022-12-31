package com.dangkang.domain.model.trade.ability.factory;

import com.dangkang.domain.model.trade.DomainObject;

/**
 * @author anzj
 * @date 2022/12/23 10:24
 */
public interface DomainObjectFactory {

    DomainObject initDomainObject(String email,String phoneNumber);
}
