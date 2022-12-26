package com.ddd.infrastructure.repositoryimpl.mapper;

import com.ddd.infrastructure.repositoryimpl.dataobject.DomainObjectDO;

/**
 * @author anzj
 * @date 2022/12/23 18:13
 */
public class DomainObjectMapperImpl implements DomainObjectMapper{
    @Override
    public int update(DomainObjectDO domainObjectDO) {
        return 1;
    }

    @Override
    public DomainObjectDO select(String phoneNumber) {
        return new DomainObjectDO("DomainObjectMapper@email.com","176*****");
    }
}
