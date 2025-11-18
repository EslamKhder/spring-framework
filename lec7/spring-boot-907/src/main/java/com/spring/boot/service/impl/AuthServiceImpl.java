package com.spring.boot.service.impl;

import com.spring.boot.config.TokenHandler;
import com.spring.boot.controller.vm.LoginRequestVM;
import com.spring.boot.controller.vm.LoginResponseVM;
import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.AuthService;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TokenHandler tokenHandler;

    @Override
    public LoginResponseVM login(LoginRequestVM requestVM) throws SystemException {
        TeacherDto teacherDto = teacherService.getByUserName(requestVM.getUserName());

        if (!teacherDto.getPassword().equals(requestVM.getPassword())) {
            throw new BadCredentialsException("invalid password");
        }

        return new LoginResponseVM(tokenHandler.createToken(teacherDto));
    }
}
