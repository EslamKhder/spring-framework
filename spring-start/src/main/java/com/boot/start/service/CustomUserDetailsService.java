package com.boot.start.service;

import com.boot.start.helpers.CustomUserDetails;
import com.boot.start.model.Employee;
import com.boot.start.repo.EmployeeRepo;
import com.boot.start.repo.StudentRepo;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // sde
        Employee employee = employeeService.getEmployeeByUSerName(username);

        if (Objects.isNull(employee)) {
            throw new UsernameNotFoundException("Invalid username");
        }
        return new CustomUserDetails(employee);
    }
}
