package com.spring.boot908.config.provider;

import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        TeacherDto teacherDto = teacherService.getTeacherByUserName(userName);
//        if (!teacherDto.getPassword().equals(password)) {
//            throw new BadCredentialsException("invalid password");
//        }
        if (!passwordEncoder.matches(password, teacherDto.getPassword())) {
            throw new BadCredentialsException("invalid password");
        }

        List<SimpleGrantedAuthority> roles = teacherDto.getRoles().stream().map(
                roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getCode())
        ).collect(Collectors.toList());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userName, password, roles);

        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
