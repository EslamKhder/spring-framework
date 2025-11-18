package com.spring.boot.resturantbackend.controllers.vm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "Order Vm",
        description = "save order related to user with products"
)
public class OrderVm {
    @Schema(
            description = "id of product",
            example = "1"
    )
    private Long id;
    @Schema(
            description = "quantity of product",
            example = "25"
    )
    private Long quantity;
}
