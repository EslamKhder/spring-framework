package com.spring.boot.restaurant.dto;

import com.spring.boot.restaurant.model.enums.RoleCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotNull(message = "User details are required")
    @Valid
    private UserDetailsDto userDetails;

    @NotEmpty(message = "At least one role is required")
    private List<@NotNull RoleCode> roles;

    private List<ContactInfoDto> contactInfos;
}
