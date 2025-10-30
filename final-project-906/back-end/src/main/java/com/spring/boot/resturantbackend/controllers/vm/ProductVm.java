package com.spring.boot.resturantbackend.controllers.vm;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVm {
    private Long id;
    private String name;
    private String image;
    private String description;
    private Double price;
}
