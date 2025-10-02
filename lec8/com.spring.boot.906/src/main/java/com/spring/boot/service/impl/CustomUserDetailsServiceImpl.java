package com.spring.boot.service.impl;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.helper.CustomUserDetails;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        StudentDto studentDto = studentService.getStudentsByUserName(username);

        return new CustomUserDetails(studentDto);
    }
}
