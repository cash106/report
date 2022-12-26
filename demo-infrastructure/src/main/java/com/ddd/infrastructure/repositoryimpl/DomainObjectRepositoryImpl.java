package com.ddd.infrastructure.repositoryimpl;

import com.ddd.domain.exception.BizException;
import com.ddd.domain.exception.ErrorConstant;
import com.ddd.domain.model.trade.DomainObject;
import com.ddd.domain.model.trade.repository.DomainObjectRepository;
import com.ddd.infrastructure.converter.DomainObjectConverter;
import com.ddd.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
import com.ddd.infrastructure.repositoryimpl.mapper.DomainObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Component
public class DomainObjectRepositoryImpl implements DomainObjectRepository {

    @Autowired
    private DomainObjectMapper domainObjectMapper;


    @Override
    public DomainObject findAndCheckEmpty(String phoneNumber) {

       DomainObjectDO domainObjectDO = domainObjectMapper.select(phoneNumber);
       return DomainObjectConverter.INSTANCE.toDomainObject(domainObjectDO);
       
    }

    @Override
    public void save(DomainObject domainObject) {

    }

    @Override
    public void update(DomainObject domainObject) {

        DomainObjectDO domainObjectDO = DomainObjectConverter.INSTANCE.toDomainObjectDO(domainObject);

        domainObjectMapper.update(domainObjectDO);
    }
}
