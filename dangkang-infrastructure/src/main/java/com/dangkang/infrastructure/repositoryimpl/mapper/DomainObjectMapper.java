package com.dangkang.infrastructure.repositoryimpl.mapper;

import com.dangkang.infrastructure.repositoryimpl.dataobject.DomainObjectDO;

/**
 * @date 2022/12/23 10:39
 */
public interface DomainObjectMapper {
    int update(DomainObjectDO domainObjectDO);

    DomainObjectDO select(String phoneNumber);

    int save(DomainObjectDO domainObjectDO);
}
