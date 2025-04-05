package com.spring.restaurant.controller.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.restaurant.service.dto.OrdersDto;
import com.spring.restaurant.service.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsVM {

    private String code;

    @JsonProperty("products")
    private List<ProductDto> productDtos;

    private String totalPrice;

    private String totalQuantity;

}
