package com.spring.restaurant.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends BaseDto {
    private String description;
    private double price;
}
