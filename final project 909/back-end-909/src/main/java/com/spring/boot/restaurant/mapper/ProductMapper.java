package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.ProductDto;
import com.spring.boot.restaurant.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDto dto);

    List<ProductDto> toDtoList(List<Product> products);
    List<Product> toEntityList(List<ProductDto> dtos);
}