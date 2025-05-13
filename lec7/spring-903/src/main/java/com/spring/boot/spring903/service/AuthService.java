package com.spring.boot.spring903.service;


import com.spring.boot.spring903.controller.vm.AccountRequestVm;
import com.spring.boot.spring903.controller.vm.AccountResponseVm;
import com.spring.boot.spring903.dto.AccountDto;

public interface AuthService {

    AccountResponseVm login(AccountRequestVm accountRequestVm);
    AccountResponseVm addAccount(AccountDto accountDto);
}
