package com.spring.boot.dto;

import com.spring.boot.model.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDto {

    private Long id;

    private String role;

//    private List<AccountDto> accounts;
}
