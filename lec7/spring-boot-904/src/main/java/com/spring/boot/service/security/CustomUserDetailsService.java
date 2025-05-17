package com.spring.boot.service.security;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            EmployeeDto employeeDto = employeeService.getEmployeeByUserName(username);
            return new CustomUserDetails(employeeDto);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }
}
