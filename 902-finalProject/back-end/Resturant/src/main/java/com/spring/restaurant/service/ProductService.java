package com.spring.restaurant.service;

import com.spring.restaurant.service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductsByCategoryId(Long categoryId);



}
