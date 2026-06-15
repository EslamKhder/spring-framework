package com.spring.boot.resturantbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.resturantbackend.controllers.vm.ProductVm;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(
        name = "Category Dto",
        description = "category dto contains (id,name,logo,flag,products)"
)
public class CategoryDto {
    private Long id;
    @NotEmpty(message = "not_empty.name")
    @Size(min = 7, max = 50, message = "size.name")
    @Schema(
            name = "name",
            description = "name for category (string)",
            example = "taher amin"
    )
    private String name;
    @NotEmpty(message = "not_empty.logo")
    private String logo;
    @NotEmpty(message = "not_empty.flag")
    private String flag;
    @Schema(
            name = "products",
            description = "list of products (List<ProductVm>)"
    )
    private List<ProductVm> products;
}
