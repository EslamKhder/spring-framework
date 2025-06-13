package com.spring.boot.resturantbackend.services.security;

import com.spring.boot.resturantbackend.vm.Security.UserAuthRequestVm;
import com.spring.boot.resturantbackend.vm.Security.UserAuthResponseVm;
import jakarta.transaction.SystemException;

public interface AuthService {
    UserAuthResponseVm signUp(UserAuthRequestVm userAuthRequestVm) throws SystemException;

    UserAuthResponseVm login(UserAuthRequestVm userAuthRequestVm) throws SystemException;
}
