package com.spring.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.demo.model.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto {

    private Long id;

    private String role;

    private List<Account> accounts;
}
