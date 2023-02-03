package com.dangkang.domain.tradecontext.ability.factory;

import com.dangkang.domain.tradecontext.model.DomainObject;

/**
 * @date 2022/12/23 10:24
 */
public interface DomainObjectFactory {

    DomainObject initDomainObject(String email,String phoneNumber);
}
