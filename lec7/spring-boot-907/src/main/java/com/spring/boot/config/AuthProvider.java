package com.spring.boot.config;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private TeacherService teacherService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        TeacherDto teacherDto = null;
        try {
            teacherDto = teacherService.getByUserName(userName);
        } catch (SystemException e) {
            throw new BadCredentialsException("invalid user name");
        }

        if (!teacherDto.getPassword().equals(password)) {
            throw new BadCredentialsException("invalid password");
        }

        List<SimpleGrantedAuthority> roles = teacherDto.getRoles().stream()
                .map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getCode())).collect(Collectors.toList());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(teacherDto, teacherDto.getPassword(), roles);

        return usernamePasswordAuthenticationToken;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
