package com.spring.boot.resturantbackend.dto.security;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
public class AccountDto {
    private Long id;
    @NotEmpty(message = "not_empty.username")
    @Size(min = 7, message = "size.username")
    private String username;
    @Size(min = 1, max = 1, message = "error.enabled")
    private String enabled;
    private List<RoleDto> roles;
    private AccountDetailsDto accountDetails;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{7,}$",
            message = "error.password"
    )
    private String password;
}
