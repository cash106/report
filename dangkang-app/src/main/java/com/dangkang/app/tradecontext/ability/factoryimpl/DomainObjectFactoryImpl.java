package com.dangkang.app.tradecontext.ability.factoryimpl;

import com.dangkang.domain.tradecontext.model.DomainObject;
import com.dangkang.domain.tradecontext.ability.factory.DomainObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactoryImpl implements DomainObjectFactory {

    @Override
    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }
}
