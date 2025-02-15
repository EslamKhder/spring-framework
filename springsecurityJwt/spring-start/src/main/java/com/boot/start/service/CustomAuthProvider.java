package com.boot.start.service;

import com.boot.start.helpers.CustomUserDetails;
import com.boot.start.model.Employee;
import com.boot.start.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class CustomAuthProvider implements AuthenticationProvider {


    @Autowired
    private EmployeeService employeeService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {//ahmed

        Employee employee = employeeService.getEmployeeByUSerName(authentication.getName());

        if (Objects.isNull(employee)) {
            throw new UsernameNotFoundException("Invalid username");
        }

        if (!employee.getPassword().equals(authentication.getCredentials())) {
            throw new UsernameNotFoundException("Invalid password");
        }

        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

        List<Role> roles = employee.getRoles();

        for (int i=0;i<roles.size();i++) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + roles.get(i).getRoleName());
            simpleGrantedAuthorities.add(grantedAuthority);
        }

        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), simpleGrantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
