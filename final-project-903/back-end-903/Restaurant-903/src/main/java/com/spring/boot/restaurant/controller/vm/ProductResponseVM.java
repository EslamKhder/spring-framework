package com.spring.boot.restaurant.controller.vm;

import com.spring.boot.restaurant.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseVM {

    private List<ProductDto> products;
    private Long size;
}
