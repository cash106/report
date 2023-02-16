package com.dangkang.domain.examplecontext.ability.factory;

import com.dangkang.domain.examplecontext.model.DomainObject;

/**
 * @date 2022/12/23 10:24
 */
public interface DomainObjectFactory {

    DomainObject initDomainObject(String email,String phoneNumber);
}
