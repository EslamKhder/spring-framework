package com.spring.restaurant.service;

import com.spring.restaurant.service.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductsByCategoryId(Long categoryId);


    List<ProductDto> getProductByLetters(String letter);

    List<ProductDto> getProducts();
}
