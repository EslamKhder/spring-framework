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

@Tag(
        name = "Product Controller",
        description = "get all products"
)
@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(
            summary = "get all products",
            description = "all products in resturant"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status get all products"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping("/all-products")
    public ResponseEntity<ProductResponseVm> getAllProducts(@RequestParam int page, @RequestParam int size)
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProducts(page, size));
    }

    @Operation(
            summary = "get all products by category id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status get all products by category id"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Http Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping("/all-products/{id}")
    public ResponseEntity<ProductResponseVm> getAllProductsByCategoryId(@PathVariable Long id, @RequestParam int page, @RequestParam int size)
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProductsByCategoryId(id, page, size));
    }


    @Operation(
            summary = "get all products by key"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status get all products by key"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Http Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping("/all-products-by-key")
    public ResponseEntity<ProductResponseVm> getAllProductsByKey(@RequestParam String key, @RequestParam int page, @RequestParam int size)
            throws SystemException {
        return ResponseEntity.ok(productService.getAllProductsByKey(key, page, size));
    }

    @Operation(
            summary = "get all products by key and category id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status get all products by key and category id"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Http Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
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
