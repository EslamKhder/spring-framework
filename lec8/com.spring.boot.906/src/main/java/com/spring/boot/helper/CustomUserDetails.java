package com.spring.boot.helper;

import com.spring.boot.dto.StudentDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private StudentDto studentDto;

    public CustomUserDetails(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return studentDto.getRoles().stream().map(
                roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getName())
        ).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return "{noop}" + studentDto.getPassword();
    }

    @Override
    public String getUsername() {
        return studentDto.getUserName();
    }
}
