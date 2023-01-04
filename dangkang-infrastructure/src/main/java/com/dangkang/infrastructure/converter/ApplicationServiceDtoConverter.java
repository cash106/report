package com.dangkang.infrastructure.converter;

import com.dangkang.client.dto.protocol.request.ApplicationServiceRequest;
import com.dangkang.client.dto.protocol.response.ApplicationServiceResponse;
import com.dangkang.client.dto.result.ApplicationServiceResult;
import com.dangkang.client.dto.ApplicationServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author anzj
 * @date 2022/12/23 10:26
 */
@Mapper
public interface ApplicationServiceDtoConverter {
    ApplicationServiceDtoConverter INSTANCE = Mappers.getMapper(ApplicationServiceDtoConverter.class);

    ApplicationServiceDTO toApplicationServiceDTO(ApplicationServiceRequest applicationServiceRequest);

    @Mapping(source = "resultType",target = "type")
    @Mapping(source = "resultCode",target = "code")
    @Mapping(source = "resultDescription",target = "message")
    ApplicationServiceResponse toApplicationServiceResponse(ApplicationServiceResult applicationServiceResult);
}
