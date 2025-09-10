package com.spring.boot.resturantbackend.controllers.vm;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
//    private Long id;
//    @NotEmpty(message = "error.user_id.not_empty")
//    private Long userId;
    @NotNull(message = "error.total_price.not_empty")
    private Double totalPrice;
    @NotNull(message = "error.total_number.not_empty")
    private Double totalNumber;
    @NotEmpty(message = "error.products_ids.not_empty")
    List<Long> productsIds;
}
