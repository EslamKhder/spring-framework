package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.controllers.vm.ProductResponseVm;
import com.spring.boot.resturantbackend.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductResponseVm getAllProducts(int page, int size);

    ProductResponseVm getAllProductsByCategoryId(Long id, int page, int size);

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> createListOfProduct(List<ProductDto> productDto);

    ProductDto updateProduct(ProductDto productDto);

    List<ProductDto> updateListOfProduct(List<ProductDto> productDto);

    void deleteProductById(Long id);

    void deleteListOfProduct(List<Long> productIds);

    ProductDto getProductById(Long id);

    ProductResponseVm getAllProductsByKey(String key, int page, int size);

    ProductResponseVm getAllProductsByCategoryIdAndKey(Long categoryId, String key, int page, int size);
}
