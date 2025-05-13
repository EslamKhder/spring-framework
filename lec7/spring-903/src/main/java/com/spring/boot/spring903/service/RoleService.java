package com.spring.boot.spring903.service;

import com.spring.boot.spring903.dto.RoleDto;
import com.spring.boot.spring903.model.Role;
import jakarta.transaction.SystemException;

import java.util.List;

public interface RoleService {

    RoleDto getRoleByName(String role) throws SystemException;
    List<RoleDto> update(List<Role> role) throws SystemException;
}
