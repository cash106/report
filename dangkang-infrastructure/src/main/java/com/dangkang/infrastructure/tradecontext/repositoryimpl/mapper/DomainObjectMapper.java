package com.dangkang.infrastructure.tradecontext.repositoryimpl.mapper;

import com.dangkang.infrastructure.tradecontext.repositoryimpl.dataobject.DomainObjectDO;

import java.util.List;

/**
 * @date 2022/12/23 10:39
 */
public interface DomainObjectMapper {
    int update(DomainObjectDO domainObjectDO);

    DomainObjectDO select(String phoneNumber);

    int save(DomainObjectDO domainObjectDO);

    List<DomainObjectDO> findList(int index,int size, String email);
}
