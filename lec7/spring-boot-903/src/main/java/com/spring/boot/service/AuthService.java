package com.spring.boot.service;

import com.spring.boot.controller.vm.AccountRequestVm;
import com.spring.boot.controller.vm.AccountResponseVm;
import com.spring.boot.dto.AccountDto;

public interface AuthService {

    AccountResponseVm login(AccountRequestVm accountRequestVm);
    AccountResponseVm addAccount(AccountDto accountDto);
}
