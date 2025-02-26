package com.spring.restaurant.service.Impl;

import com.spring.restaurant.mapper.ProductMapper;
import com.spring.restaurant.model.Product;
import com.spring.restaurant.repository.ProductRepository;
import com.spring.restaurant.service.ProductService;
import com.spring.restaurant.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    @Override
    public List<ProductDto> getProductByLetters(String letter) { //
        List<Product> products = productRepository.getProductByLetters(letter);

        //<Product> products = productRepository.getProductByLetters(letter);

        if (products.isEmpty()) {
            throw new RuntimeException("error.noSuchLetter");
        }
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public List<ProductDto> getProducts() {
        return ProductMapper.PRODUCT_MAPPER.toDtoList(productRepository.findAll());
    }
}
