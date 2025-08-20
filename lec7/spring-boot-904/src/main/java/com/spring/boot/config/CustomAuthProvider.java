package com.spring.boot.config;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.service.AccountService;
import com.spring.boot.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            String userName = authentication.getPrincipal().toString();
            String password = authentication.getCredentials().toString();

            EmployeeDto employeeDto = employeeService.getEmployeeByUserName(userName);

            if (Objects.isNull(employeeDto)) {
                throw new SystemException("account not exist with user-name " + userName);
            }
            if (!password.equals(employeeDto.getPassword())) {
                throw new SystemException("invalid password");
            }

            List<GrantedAuthority> roles = employeeDto.getRoleDtos().stream().map(roleDto ->
                    new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());


            return new UsernamePasswordAuthenticationToken(employeeDto, password, roles);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
