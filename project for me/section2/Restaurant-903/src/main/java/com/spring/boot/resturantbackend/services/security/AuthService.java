package com.spring.boot.resturantbackend.services.security;

import com.spring.boot.resturantbackend.vm.Security.AccountAuthRequestVm;
import com.spring.boot.resturantbackend.vm.Security.AccountAuthResponseVm;

public interface AuthService {
    AccountAuthResponseVm signUp(AccountAuthRequestVm accountAuthRequestVm);

    AccountAuthResponseVm login(AccountAuthRequestVm accountAuthRequestVm);
}
