package com.spring.boot.restaurant.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class OrderDto {

    private Long id;

    @NotBlank(message = "Order code is required")
    private String code;

    @NotNull(message = "Total price is required")
    @PositiveOrZero(message = "Total price must be zero or positive")
    private Double totalPrice;

    @Min(value = 0, message = "Total number cannot be negative")
    private int totalNumber;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Products list cannot be null")
    @Size(min = 1, message = "At least one product is required")
    private List<ProductDto> products;
}