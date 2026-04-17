package com.ecom.product.mapper;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.entity.ProductEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductRequest toDto(ProductEntity productEntity);

    ProductEntity toEntity(ProductRequest productRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ProductRequest productRequest, @MappingTarget ProductEntity entity);

}
