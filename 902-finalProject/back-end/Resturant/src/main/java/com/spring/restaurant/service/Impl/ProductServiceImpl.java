package com.spring.restaurant.service.Impl;

import com.spring.restaurant.controller.vm.ProductResponseVM;
import com.spring.restaurant.mapper.CategoryMapper;
import com.spring.restaurant.mapper.ProductMapper;
import com.spring.restaurant.model.Product;
import com.spring.restaurant.repository.ProductRepository;
import com.spring.restaurant.service.CategoryService;
import com.spring.restaurant.service.ProductService;
import com.spring.restaurant.service.dto.CategoryDto;
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

    @Autowired
    private CategoryService categoryService;
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

    @Override
    public List<ProductDto> findProductsByIds(List<Long> porductIds) {
        List <Product> products = productRepository.findAllById(porductIds);
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductMapper.PRODUCT_MAPPER.toEntity(productDto);
        CategoryDto categoryDto = categoryService.findById(productDto.getCategoryId());

        product.setCategory(CategoryMapper.CATEGORY_MAPPER.toEntity(categoryDto));

        return ProductMapper.PRODUCT_MAPPER.toDto(productRepository.save(product));
    }
}
