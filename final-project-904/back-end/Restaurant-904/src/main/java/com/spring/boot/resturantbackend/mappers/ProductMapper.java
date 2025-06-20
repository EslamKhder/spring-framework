package com.spring.boot.resturantbackend.mappers;

import com.spring.boot.resturantbackend.dto.ProductDto;
import com.spring.boot.resturantbackend.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);
    List<ProductDto> toProductDtoList(List<Product> productDto);
    List<Product> toProductList(List<ProductDto> productDto);
}
