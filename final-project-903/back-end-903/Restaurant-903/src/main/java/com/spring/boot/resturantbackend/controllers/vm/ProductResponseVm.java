package com.spring.boot.resturantbackend.controllers.vm;

import com.spring.boot.resturantbackend.dto.ProductDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Product Response Vm",
        description = "product response with {products, totalProducts}"
)
public class ProductResponseVm {
    @Schema(
            description = "return list of products"
    )
    private List<ProductDto> products;
    @Schema(
            description = "return totalProducts"
    )
    private Long totalProducts;
}
