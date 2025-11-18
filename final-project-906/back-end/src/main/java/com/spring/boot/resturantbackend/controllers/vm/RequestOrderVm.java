package com.spring.boot.resturantbackend.controllers.vm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(
       name = "Order",
        description = "save order related to user with products"
)
public class RequestOrderVm {
    @Schema(
            description = "this list of OrderVm"
    )
    private List<OrderVm> products;
}
