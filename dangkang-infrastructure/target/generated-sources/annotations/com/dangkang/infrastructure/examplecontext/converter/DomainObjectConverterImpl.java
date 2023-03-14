package com.dangkang.infrastructure.examplecontext.converter;

import com.dangkang.client.examplecontext.dto.response.QueryResultDTO;
import com.dangkang.domain.examplecontext.ability.facade.CallRequestDto;
import com.dangkang.domain.examplecontext.model.DomainObject;
import com.dangkang.infrastructure.examplecontext.repositoryimpl.dataobject.DomainObjectDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-14T09:41:27+0800",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class DomainObjectConverterImpl implements DomainObjectConverter {

    @Override
    public DomainObjectDO toDomainObjectDO(DomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        String email = null;
        String phoneNumber = null;

        email = domainObject.getEmail();
        phoneNumber = domainObject.getPhoneNumber();

        DomainObjectDO domainObjectDO = new DomainObjectDO( email, phoneNumber );

        return domainObjectDO;
    }

    @Override
    public DomainObject toDomainObject(DomainObjectDO domainObjectDO) {
        if ( domainObjectDO == null ) {
            return null;
        }

        DomainObject domainObject = new DomainObject();

        domainObject.setEmail( domainObjectDO.getEmail() );
        domainObject.setPhoneNumber( domainObjectDO.getPhoneNumber() );

        return domainObject;
    }

    @Override
    public CallRequestDto toCallRequestDto(DomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        CallRequestDto callRequestDto = new CallRequestDto();

        callRequestDto.setEmail( domainObject.getEmail() );
        callRequestDto.setPhoneNumber( domainObject.getPhoneNumber() );

        return callRequestDto;
    }

    @Override
    public List<DomainObject> toDomainObjectList(List<DomainObjectDO> domainObjects) {
        if ( domainObjects == null ) {
            return null;
        }

        List<DomainObject> list = new ArrayList<DomainObject>( domainObjects.size() );
        for ( DomainObjectDO domainObjectDO : domainObjects ) {
            list.add( toDomainObject( domainObjectDO ) );
        }

        return list;
    }

    @Override
    public List<QueryResultDTO> toQueryResultDataDtoList(List<DomainObject> domainObjects) {
        if ( domainObjects == null ) {
            return null;
        }

        List<QueryResultDTO> list = new ArrayList<QueryResultDTO>( domainObjects.size() );
        for ( DomainObject domainObject : domainObjects ) {
            list.add( domainObjectToQueryResultDTO( domainObject ) );
        }

        return list;
    }

    protected QueryResultDTO domainObjectToQueryResultDTO(DomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        QueryResultDTO queryResultDTO = new QueryResultDTO();

        queryResultDTO.setEmail( domainObject.getEmail() );
        queryResultDTO.setPhoneNumber( domainObject.getPhoneNumber() );

        return queryResultDTO;
    }
}
