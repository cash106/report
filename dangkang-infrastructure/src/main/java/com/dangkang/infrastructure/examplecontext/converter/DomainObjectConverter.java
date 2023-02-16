package com.dangkang.infrastructure.examplecontext.converter;

import com.dangkang.client.examplecontext.dto.response.QueryResultDTO;
import com.dangkang.domain.examplecontext.model.DomainObject;
import com.dangkang.domain.examplecontext.ability.facade.CallRequestDto;
import com.dangkang.infrastructure.examplecontext.repositoryimpl.dataobject.DomainObjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @date 2022/12/23 18:01
 */
@Mapper
public interface DomainObjectConverter {
    DomainObjectConverter INSTANCE = Mappers.getMapper(DomainObjectConverter.class);

    DomainObjectDO toDomainObjectDO(DomainObject domainObject);

    DomainObject toDomainObject(DomainObjectDO domainObjectDO);

    CallRequestDto toCallRequestDto(DomainObject domainObject);

    List<DomainObject> toDomainObjectList(List<DomainObjectDO> domainObjects);

    List<QueryResultDTO> toQueryResultDataDtoList(List<DomainObject> domainObjects);

}
