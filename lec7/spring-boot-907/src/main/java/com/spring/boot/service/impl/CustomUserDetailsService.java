package com.spring.boot.service.impl;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.helper.CustomUserDetails;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

//@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TeacherService teacherService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            TeacherDto teacherDto = teacherService.getByUserName(username);
            return new CustomUserDetails(teacherDto);
        } catch (SystemException e) {
            return null;
        }
    }
}
