package com.ddd.infrastructure.repositoryimpl.mapper;

import com.ddd.infrastructure.repositoryimpl.dataobject.DomainObjectDO;

/**
 * @author anzj
 * @date 2022/12/23 10:39
 */
public interface DomainObjectMapper {
    int update(DomainObjectDO domainObjectDO);

    DomainObjectDO select(String phoneNumber);
}
