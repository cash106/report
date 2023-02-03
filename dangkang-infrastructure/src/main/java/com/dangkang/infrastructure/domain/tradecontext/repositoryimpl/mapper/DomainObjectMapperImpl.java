package com.dangkang.infrastructure.domain.tradecontext.repositoryimpl.mapper;

import com.dangkang.infrastructure.domain.tradecontext.repositoryimpl.dataobject.DomainObjectDO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 暂无dataSource，自定义mapper实现
 * @date 2022/12/23 18:13
 */
@Component
public class DomainObjectMapperImpl implements DomainObjectMapper{
    @Override
    public int update(DomainObjectDO domainObjectDO) {
        return 1;
    }

    @Override
    public DomainObjectDO select(String phoneNumber) {
        return new DomainObjectDO("DomainObjectMapper@email.com","176*****");
    }

    @Override
    public int save(DomainObjectDO domainObjectDO) {
        return 0;
    }

    @Override
    public List<DomainObjectDO> findList(int index,int size,String email) {
        List<DomainObjectDO> domainObjectDOS = new ArrayList<>();
        domainObjectDOS.add(new DomainObjectDO("DomainObjectMapper@email.com","176*****"));
        domainObjectDOS.add(new DomainObjectDO("DomainObjectMapper@email.com","199*****"));
        return domainObjectDOS;
    }
}
