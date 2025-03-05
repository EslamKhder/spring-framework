package com.spring.restaurant.service.Impl;

import com.spring.restaurant.controller.vm.ProductResponseVM;
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
    public ProductResponseVM getProductsByCategoryId(Long categoryId, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepository.findAllByCategoryId(categoryId, pageable);

        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(productPage.getContent()),
                productPage.getTotalElements()
        );
    }


    @Override
    public ProductResponseVM getProductByLetters(String letter, Integer pageNo, Integer pageSize) { //
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepository.getProductByLetters(letter, pageable);
        List<Product> products = productPage.getContent();

        if (products.isEmpty()) {
            throw new RuntimeException("error.noSuchLetter");
        }
        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(products),
                productPage.getTotalElements()
        );
    }

    @Override
    public ProductResponseVM getProducts(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Product> productPage = productRepository.findAll(pageable);

        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(productPage.getContent()),
                productPage.getTotalElements()
        );
    }
}
