package com.spring.boot.restaurant.controller;

import com.spring.boot.restaurant.dto.PageResponse;
import com.spring.boot.restaurant.dto.ProductDto;
import com.spring.boot.restaurant.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<PageResponse<ProductDto>> getAllProducts(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<ProductDto> page = productService.getAllProducts(pageNumber, pageSize);
        return ResponseEntity.ok(new PageResponse<>(
                page.getContent(),
                page.getTotalElements(),
                page.getNumberOfElements(),
                page.getNumber(),
                page.getTotalPages(),
                page.getSize()
            )
        );
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @PostMapping("/createList")
    public ResponseEntity<List<ProductDto>> createProductList(@RequestBody List<ProductDto> productDtoList) {
        return ResponseEntity.ok(productService.saveProductList(productDtoList));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable Long id) {
        boolean deleted = productService.deleteProductById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteList")
    public ResponseEntity<Boolean> deleteProductsByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(productService.deleteProductsByIds(ids));
    }

    @GetMapping("/searchByCategoryId/{categoryId}")
    public ResponseEntity<PageResponse<ProductDto>> getProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<ProductDto> page = productService.getProductsByCategoryId(categoryId, pageNumber, pageSize);
        return ResponseEntity.ok(new PageResponse<>(
                        page.getContent(),
                        page.getTotalElements(),
                        page.getNumberOfElements(),
                        page.getNumber(),
                        page.getTotalPages(),
                        page.getSize()
                )
        );
    }

    @GetMapping("/searchByCategoryName/{categoryName}")
    public ResponseEntity<PageResponse<ProductDto>> getProductsByCategoryName(
            @PathVariable String categoryName,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Page<ProductDto> page = productService.getProductsByCategoryName(categoryName, pageNumber, pageSize);
        return ResponseEntity.ok(new PageResponse<>(
                        page.getContent(),
                        page.getTotalElements(),
                        page.getNumberOfElements(),
                        page.getNumber(),
                        page.getTotalPages(),
                        page.getSize()
                )
        );
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponse<ProductDto>> searchProducts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Page<ProductDto> page = productService.searchProducts(keyword, pageNumber, pageSize);
        return ResponseEntity.ok(new PageResponse<>(
                        page.getContent(),
                        page.getTotalElements(),
                        page.getNumberOfElements(),
                        page.getNumber(),
                        page.getTotalPages(),
                        page.getSize()
                )
        );
    }

    @GetMapping("/searchByKeywordAndCategoryId")
    public ResponseEntity<PageResponse<ProductDto>> searchProductsByKeywordAndCategoryId(
            @RequestParam String keyword,
            @RequestParam Long categoryId,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Page<ProductDto> page = productService.searchByKeywordAndCategory(keyword, categoryId, pageNumber, pageSize);
        return ResponseEntity.ok(new PageResponse<>(
                        page.getContent(),
                        page.getTotalElements(),
                        page.getNumberOfElements(),
                        page.getNumber(),
                        page.getTotalPages(),
                        page.getSize()
                )
        );
    }
}
