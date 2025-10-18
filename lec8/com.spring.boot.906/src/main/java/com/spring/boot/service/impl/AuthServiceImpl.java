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

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    private StudentService studentService;

    private TokenHandler tokenHandler;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(StudentService studentService, TokenHandler tokenHandler, PasswordEncoder passwordEncoder) {
        this.studentService = studentService;
        this.tokenHandler = tokenHandler;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponseVm login(AuthRequestVm authRequestVm) throws SystemException {
        StudentDto studentDto = studentService.getStudentsByUserName(authRequestVm.getUserName());

        if (!passwordEncoder.matches(authRequestVm.getPassword(), studentDto.getPassword())) {
            throw new SystemException("invalid Password");
        }

        return new AuthResponseVm(tokenHandler.createToken(studentDto));
    }

    @Override
    public AuthResponseVm signup(StudentDto studentDto) throws SystemException {
        studentDto =  studentService.saveStudent(studentDto);
        if (Objects.isNull(studentDto)) {
            throw new SystemException("account not created");
        }

        return new AuthResponseVm(tokenHandler.createToken(studentDto));
    }

}
