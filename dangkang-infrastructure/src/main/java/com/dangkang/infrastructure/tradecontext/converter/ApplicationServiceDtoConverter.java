package com.dangkang.infrastructure.tradecontext.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @date 2022/12/23 10:26
 */
@Mapper
public interface ApplicationServiceDtoConverter {
    ApplicationServiceDtoConverter INSTANCE = Mappers.getMapper(ApplicationServiceDtoConverter.class);
}
