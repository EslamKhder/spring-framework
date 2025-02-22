package com.spring.restaurant.mapper;

import com.spring.restaurant.model.Product;
import com.spring.restaurant.service.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);
    List<ProductDto> toDtoList(List<Product> products);

    Product toEntity(ProductDto productDto);
    List<Product> toEntityList(List<ProductDto> productDtos);
}
