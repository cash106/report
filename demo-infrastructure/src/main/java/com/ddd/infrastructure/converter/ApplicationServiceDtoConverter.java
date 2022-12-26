package com.ddd.infrastructure.converter;

import com.ddd.client.dto.protocol.request.ApplicationServiceRequest;
import com.ddd.client.dto.protocol.response.ApplicationServiceResponse;
import com.ddd.client.dto.result.ApplicationServiceResult;
import com.ddd.client.dto.valueobject.ApplicationServiceVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author anzj
 * @date 2022/12/23 10:26
 */
@Mapper
public interface ApplicationServiceDtoConverter {
    ApplicationServiceDtoConverter INSTANCE = Mappers.getMapper(ApplicationServiceDtoConverter.class);

    ApplicationServiceVO toApplicationServiceVO(ApplicationServiceRequest applicationServiceRequest);

    ApplicationServiceResponse toApplicationServiceResponse(ApplicationServiceResult applicationServiceResult);
}
