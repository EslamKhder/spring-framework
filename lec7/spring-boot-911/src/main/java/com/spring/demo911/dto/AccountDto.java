package com.spring.demo911.dto;

import com.spring.demo911.model.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {


    private Long id;

    private String email;

    private String password;

    private List<RoleDto> roles;



}
