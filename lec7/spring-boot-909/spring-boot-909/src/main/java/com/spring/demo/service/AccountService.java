package com.spring.demo.service;

import com.spring.demo.controller.vm.LoginResponseVM;
import com.spring.demo.dto.AccountDto;
import com.spring.demo.dto.TeacherDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface AccountService {


    AccountDto getByUserName(String userName) throws SystemException;

    LoginResponseVM login(AccountDto accountDto) throws SystemException;
    LoginResponseVM signup(AccountDto accountDto);
}
