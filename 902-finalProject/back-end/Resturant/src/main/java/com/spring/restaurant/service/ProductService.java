package com.spring.restaurant.service;

import com.spring.restaurant.controller.vm.ProductResponseVM;
import com.spring.restaurant.service.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponseVM getProductsByCategoryId(Long categoryId, Integer pageNo, Integer pageSize);


    ProductResponseVM getProductByLetters(String letter, Integer pageNo, Integer pageSize);

    ProductResponseVM getProducts(Integer pageNo, Integer pageSize);
}
