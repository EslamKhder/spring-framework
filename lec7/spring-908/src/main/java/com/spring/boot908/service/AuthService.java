package com.spring.boot908.service;

import com.spring.boot908.controller.vm.LoginRequestVM;
import com.spring.boot908.controller.vm.LoginResponseVM;
import com.spring.boot908.dto.TeacherDto;
import jakarta.transaction.SystemException;

public interface AuthService {

    void signUp(TeacherDto teacherDto) throws SystemException;
    LoginResponseVM login(LoginRequestVM loginRequestVm) throws SystemException;



}
