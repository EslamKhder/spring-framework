package com.spring.boot.service;

import com.spring.boot.controller.vm.AuthRequestVm;
import com.spring.boot.controller.vm.AuthResponseVm;
import com.spring.boot.dto.StudentDto;
import jakarta.transaction.SystemException;

public interface AuthService {


    AuthResponseVm login(AuthRequestVm authRequestVm) throws SystemException;
    AuthResponseVm signup(StudentDto studentDto) throws SystemException;
}
