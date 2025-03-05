package com.spring.restaurant.controller.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.restaurant.service.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class ProductResponseVM {

    @JsonProperty("products")
    private List<ProductDto> productDtos;

    @JsonProperty("totalProductSize")
    private Long totalProductSize;
}
