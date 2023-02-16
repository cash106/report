package com.dangkang.app.examplecontext.ability.factoryimpl;

import com.dangkang.domain.examplecontext.model.DomainObject;
import com.dangkang.domain.examplecontext.ability.factory.DomainObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class DomainObjectFactoryImpl implements DomainObjectFactory {

    @Override
    public DomainObject initDomainObject(String email, String phoneNumber) {

        DomainObject domainObject = new DomainObject(email,phoneNumber);
        return domainObject;
    }
}
