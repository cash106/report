package com.dangkang.infrastructure.converter;

import com.dangkang.domain.model.trade.DomainObject;
import com.dangkang.domain.model.trade.type.CallRequestDto;
import com.dangkang.infrastructure.repositoryimpl.dataobject.DomainObjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/12/23 18:01
 */
@Mapper
public interface DomainObjectConverter {
    DomainObjectConverter INSTANCE = Mappers.getMapper(DomainObjectConverter.class);

    DomainObjectDO toDomainObjectDO(DomainObject domainObject);

    DomainObject toDomainObject(DomainObjectDO domainObjectDO);

    CallRequestDto toCallRequestDto(DomainObject domainObject);
}
