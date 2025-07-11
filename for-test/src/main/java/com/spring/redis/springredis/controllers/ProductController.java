package com.spring.redis.springredis.controllers;


import com.spring.redis.springredis.services.impl.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/slow")
    public void slow() throws InterruptedException {
        productService.slowService();
    }
}