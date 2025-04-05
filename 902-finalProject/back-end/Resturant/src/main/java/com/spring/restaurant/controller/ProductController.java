package com.spring.restaurant.controller;

import com.spring.restaurant.controller.vm.ProductResponseVM;
import com.spring.restaurant.service.ProductService;
import com.spring.restaurant.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("pageNo/{pageNo}/pageSize/{pageSize}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<ProductResponseVM> productAllProducts(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(productService.getProducts(pageNo, pageSize));
    }

    @GetMapping("/category/categoryId/{categoryId}/pageNo/{pageNo}/pageSize/{pageSize}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<ProductResponseVM> productAllProducts(@PathVariable("categoryId") Long categoryId, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId, pageNo, pageSize));
    }

    @GetMapping("/search/{letters}/pageNo/{pageNo}/pageSize/{pageSize}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<ProductResponseVM> search(@PathVariable("letters") String Letter, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(productService.getProductByLetters(Letter, pageNo, pageSize));
    }

    @PostMapping("/product/addProduct")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

}
