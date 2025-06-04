package com.spring.boot.resturantbackend.controllers;

import com.spring.boot.resturantbackend.controllers.vm.ProductResponseVm;
import com.spring.boot.resturantbackend.dto.ExceptionDto;
import com.spring.boot.resturantbackend.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "ProductController",
        description = "Product Controller to create , update , delete and select"
)
@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(
            summary = "all-products API",
            description = "this api to get all products"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status get all products"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            )
    })
    @GetMapping("/all-products")
    public ResponseEntity<ProductResponseVm> getAllProducts(@RequestParam int page, @RequestParam int size)
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProducts(page, size));
    }

    @GetMapping("/all-products/{id}")
    public ResponseEntity<ProductResponseVm> getAllProductsByCategoryId(@PathVariable Long id, @RequestParam int page, @RequestParam int size)
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProductsByCategoryId(id, page, size));
    }

    @GetMapping("/all-products-by-key")
    public ResponseEntity<ProductResponseVm> getAllProductsByKey(@RequestParam String key, @RequestParam int page, @RequestParam int size)
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProductsByKey(key, page, size));
    }

    @GetMapping("/all-products-by-key-and-category-id")
    public ResponseEntity<ProductResponseVm> getAllProductsByKeyAndCategoryId(
            @RequestParam Long categoryId,
            @RequestParam String key,
            @RequestParam int page,
            @RequestParam int size
    )
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProductsByCategoryIdAndKey(categoryId, key, page, size));
    }
}
