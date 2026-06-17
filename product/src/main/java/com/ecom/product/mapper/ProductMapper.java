package com.ecom.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
	
	ProductDto toDto(Product product);
	Product toEntity(ProductDto dto);
	
	
}
