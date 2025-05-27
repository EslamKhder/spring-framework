package com.spring.boot.restaurant.controller;

import com.spring.boot.restaurant.controller.vm.ProductResponseVM;
import com.spring.boot.restaurant.dto.ProductDto;
import com.spring.boot.restaurant.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/getAll")
    public ResponseEntity<ProductResponseVM> getAllProducts(@RequestParam("pageNumber")int pageNumber, @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(productService.getAllProducts(pageNumber, pageSize));
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

    @DeleteMapping("/deleteList")
    public ResponseEntity<Boolean> deleteProductsByIds(@RequestBody List<Long> ids) {

        return ResponseEntity.ok(productService.deleteProductsByIds(ids));
    }


    @GetMapping("/searchByCategoryId/{categoryId}")
    public ResponseEntity<ProductResponseVM> getProductsByCategoryId(@PathVariable Long categoryId, @RequestParam("pageNumber")int pageNumber, @RequestParam("pageSize") int pageSize) {

        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId, pageNumber, pageSize));
    }

    @GetMapping("/searchByCategoryName/{categoryName}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity.ok(productService.getProductsByCategoryName(categoryName));
    }


    @GetMapping("/search")
    public ResponseEntity<ProductResponseVM> searchProducts(@RequestParam String keyword,@RequestParam("pageNumber")int pageNumber, @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(productService.searchProducts(keyword, pageNumber, pageSize));
    }

    @GetMapping("/categorySearch")
    public ResponseEntity<ProductResponseVM> searchProducts(@RequestParam Long categoryId,
                                                            @RequestParam String keyword,
                                                            @RequestParam("pageNumber")int pageNumber,
                                                            @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(productService.searchByCategoryIdAndKeyWord(categoryId, keyword, pageNumber, pageSize));
    }
}
