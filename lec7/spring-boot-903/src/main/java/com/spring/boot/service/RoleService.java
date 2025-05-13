package com.spring.boot.service;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.exceptions.IdMisMatchException;
import com.spring.boot.model.Role;
import jakarta.transaction.SystemException;

import java.util.List;

public interface RoleService {

    RoleDto getRoleByName(String role) throws SystemException;
    List<RoleDto> update(List<Role> role) throws SystemException;
}
