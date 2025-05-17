package com.spring.boot.service.security;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private EmployeeDto employeeDto;

    public CustomUserDetails(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return employeeDto.getRoleDtos().stream().map(roleDto ->
                new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return "{noop}" + employeeDto.getPassword();
    }

    @Override
    public String getUsername() {
        return employeeDto.getUserName();
    }
}
