package com.spring.boot.resturantbackend.services.security;

import com.spring.boot.resturantbackend.dto.security.RoleDto;

public interface RoleService {
    RoleDto findByRole(String role);
}
