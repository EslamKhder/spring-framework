package com.spring.boot.resturantbackend.controllers.vm;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrderVm {
    private String code;
    @NotEmpty(message = "error.total_price.not_empty")
    private double totalPrice;
    @NotEmpty(message = "error.total_number.not_empty")
    private double totalNumber;
}
