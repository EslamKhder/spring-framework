package com.spring.boot.helper;

import com.spring.boot.dto.TeacherDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private TeacherDto teacherDto;

    public CustomUserDetails(TeacherDto teacherDto) {
        this.teacherDto = teacherDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return teacherDto.getRoles().stream()
                .map(roleDto -> new SimpleGrantedAuthority("ROLE_" + roleDto.getCode())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return "{noop}" + teacherDto.getPassword();
    }

    @Override
    public String getUsername() {
        return teacherDto.getUserName();
    }

}
