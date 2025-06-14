package com.spring.boot.resturantbackend.vm;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestOrderVm {
    private Long id;
    @NotEmpty(message = "error.user_id.not_empty")
    private Long userId;
    @NotEmpty(message = "error.total_price.not_empty")
    private double totalPrice;
    @NotEmpty(message = "error.total_number.not_empty")
    private double totalNumber;
    @NotEmpty(message = "error.products_ids.not_empty")
    List<Long> productsIds;
}
