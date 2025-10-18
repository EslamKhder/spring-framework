package com.spring.boot.config.provider;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private StudentService studentService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        StudentDto studentDto = studentService.getStudentsByUserName(userName);

        if (!studentDto.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid password");
        }

        List<GrantedAuthority> roles =  studentDto.getRoles().stream().map(
                roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getName())
        ).collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(studentDto, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
