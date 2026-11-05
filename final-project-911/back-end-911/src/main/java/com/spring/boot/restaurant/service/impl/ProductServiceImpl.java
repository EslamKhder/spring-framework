package com.spring.boot.restaurant.service.impl;

import com.spring.boot.restaurant.dto.ProductDto;
import com.spring.boot.restaurant.exception.BadRequestException;
import com.spring.boot.restaurant.exception.NotFoundException;
import com.spring.boot.restaurant.mapper.ProductMapper;
import com.spring.boot.restaurant.model.Product;
import com.spring.boot.restaurant.repository.ProductRepo;
import com.spring.boot.restaurant.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return productMapper.toDtoList(products);
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepo.findById(id)
                .map(productMapper::toDto)
                .orElse(null);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        if (productDto.getName() == null || productDto.getName().isBlank()) {
            throw new BadRequestException("Product name must not be empty");
        }

        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepo.save(product));
    }

    @Override
    public boolean deleteProductById(Long id) {
        if (!productRepo.existsById(id)) {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        if (productDto.getId() == null || !productRepo.existsById(productDto.getId())) {
            throw new NotFoundException("Product with ID " + productDto.getId() + " not found");
        }

        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepo.save(product));
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        List<Product> products = productRepo.findByCategoryId(categoryId);
        return productMapper.toDtoList(products);
    }

    @Override
    public List<ProductDto> getProductsByCategoryName(String categoryName) {
        List<Product> products = productRepo.findByCategoryName(categoryName);
        return productMapper.toDtoList(products);
    }

    @Override
    public List<ProductDto> searchProducts(String keyword) {
        List<Product> products = productRepo
                .findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);

        return productMapper.toDtoList(products);
    }

    @Override
    public boolean deleteProductsByIds(List<Long> ids) {
        List<Product> products = productRepo.findAllById(ids);
        if (products.isEmpty()) {
            return false;
        }
        productRepo.deleteAll(products);
        return true;
    }
}