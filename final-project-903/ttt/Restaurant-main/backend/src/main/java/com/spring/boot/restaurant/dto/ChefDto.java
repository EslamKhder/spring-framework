package com.spring.boot.restaurant.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can’t be longer than 100 characters")
    private String name;

    @NotBlank(message = "Specialization is required")
    @Size(max = 150, message = "Specialization can’t be longer than 150 characters")
    private String specialization;

    @NotBlank(message = "Logo path is required")
    @Size(max = 255, message = "Logo path can’t be longer than 255 characters")
    private String logoPath;

    @Size(max = 255, message = "Facebook link can’t be longer than 255 characters")
    private String facebook;

    @Size(max = 255, message = "Twitter link can’t be longer than 255 characters")
    private String twitter;

    @Size(max = 255, message = "Instagram link can’t be longer than 255 characters")
    private String instagram;
}
