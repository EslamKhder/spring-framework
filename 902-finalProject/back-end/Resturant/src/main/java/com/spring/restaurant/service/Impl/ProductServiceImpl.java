package com.spring.restaurant.service.Impl;

import com.spring.restaurant.mapper.ProductMapper;
import com.spring.restaurant.repository.ProductRepository;
import com.spring.restaurant.service.ProductService;
import com.spring.restaurant.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        return ProductMapper.PRODUCT_MAPPER.toDtoList(productRepository.findAllByCategoryId(categoryId));
    }

}
