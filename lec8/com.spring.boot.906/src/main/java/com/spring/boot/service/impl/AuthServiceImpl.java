package com.spring.boot.service.impl;

import com.spring.boot.config.jwt.TokenHandler;
import com.spring.boot.controller.vm.AuthRequestVm;
import com.spring.boot.controller.vm.AuthResponseVm;
import com.spring.boot.dto.StudentDto;
import com.spring.boot.service.AuthService;
import com.spring.boot.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private StudentService studentService;

    private TokenHandler tokenHandler;



    @Autowired
    public AuthServiceImpl(StudentService studentService, TokenHandler tokenHandler) {
        this.studentService = studentService;
        this.tokenHandler = tokenHandler;
    }

    @Override
    public AuthResponseVm login(AuthRequestVm authRequestVm) throws SystemException {

        StudentDto studentDto = studentService.getStudentsByUserName(authRequestVm.getUserName());

        if (!studentDto.getPassword().equals(authRequestVm.getPassword())) {
            throw new SystemException("invalid Password");
        }


        return new AuthResponseVm(tokenHandler.createToken(studentDto));
    }

    @Override
    public AuthResponseVm signup(StudentDto studentDto) {
        // student   user
        return null;
    }
}
