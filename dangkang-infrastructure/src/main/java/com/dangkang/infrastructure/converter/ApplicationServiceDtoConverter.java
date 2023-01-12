package com.dangkang.infrastructure.converter;

import com.dangkang.client.dto.protocol.request.ApplicationServiceRequest;
import com.dangkang.client.dto.response.resultdto.ApplicationServiceResultDTO;
import com.dangkang.client.dto.request.requestdto.ApplicationServiceRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/12/23 10:26
 */
@Mapper
public interface ApplicationServiceDtoConverter {
    ApplicationServiceDtoConverter INSTANCE = Mappers.getMapper(ApplicationServiceDtoConverter.class);

    ApplicationServiceRequestDTO toApplicationServiceDTO(ApplicationServiceRequest applicationServiceRequest);

    @Mapping(source = "resultType",target = "type")
    @Mapping(source = "resultCode",target = "code")
    @Mapping(source = "resultDescription",target = "message")
    com.dangkang.client.dto.protocol.response.ApplicationServiceResponse toApplicationServiceResponse(ApplicationServiceResultDTO applicationServiceResult);

}
