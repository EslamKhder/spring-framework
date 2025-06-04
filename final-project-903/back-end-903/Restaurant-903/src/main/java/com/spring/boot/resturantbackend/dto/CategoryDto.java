package com.spring.boot.resturantbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.resturantbackend.vm.ProductVm;
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
public class CategoryDto {
    private Long id;
    @NotEmpty(message = "not_empty.name")
    @Size(min = 7, max = 50, message = "size.name")
    @Schema(
            description = "return totalProducts", example = "Islam ahmed"
    )
    private String name;
    @NotEmpty(message = "not_empty.logo")
    private String logo;
    @NotEmpty(message = "not_empty.flag")
    private String flag;
    @Schema(
            description = "phone number of user", example = "+201113903660"
    )
    private String phone;
    private List<ProductVm> products;

}
