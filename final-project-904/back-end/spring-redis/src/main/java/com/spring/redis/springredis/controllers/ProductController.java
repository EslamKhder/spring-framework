package com.spring.redis.springredis.controllers;

import com.spring.redis.springredis.models.Product;
import com.spring.redis.springredis.services.ProductService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/all-products")
    public ResponseEntity<List<Product>> getAllProducts()
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/add-product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
            throws SystemException {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/update-product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)
            throws SystemException {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<Void> saveProduct(@PathVariable Long id)
            throws SystemException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // TODO TASK create api to get product by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductBy(id));
    }


}
