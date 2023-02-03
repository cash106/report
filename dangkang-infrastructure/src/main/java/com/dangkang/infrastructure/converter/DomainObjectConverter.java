package com.dangkang.infrastructure.converter;

import com.dangkang.client.dto.response.resultdto.QueryResultDTO;
import com.dangkang.domain.model.tradecontext.DomainObject;
import com.dangkang.domain.model.tradecontext.type.CallRequestDto;
import com.dangkang.infrastructure.domain.tradecontext.repositoryimpl.dataobject.DomainObjectDO;
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
