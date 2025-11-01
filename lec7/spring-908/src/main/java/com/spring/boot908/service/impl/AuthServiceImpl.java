package com.spring.boot908.service.impl;

import com.spring.boot908.config.jwt.TokenHandler;
import com.spring.boot908.controller.vm.LoginRequestVM;
import com.spring.boot908.controller.vm.LoginResponseVM;
import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.model.Teacher;
import com.spring.boot908.service.AuthService;
import com.spring.boot908.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenHandler tokenHandler;



    @Override
    public void signUp(TeacherDto teacherDto) throws SystemException {
        teacherService.saveTeacher(teacherDto);
    }

    @Override
    public LoginResponseVM login(LoginRequestVM loginRequestVm) throws SystemException {
        TeacherDto teacherDto = teacherService.getTeacherByUserName(loginRequestVm.getUsername());

        if (!passwordEncoder.matches(loginRequestVm.getPassword(), teacherDto.getPassword())) {
            throw new SystemException("invalid.password.error");
        }


        String token = tokenHandler.createToken(teacherDto);
        return new LoginResponseVM(token);
    }
}
