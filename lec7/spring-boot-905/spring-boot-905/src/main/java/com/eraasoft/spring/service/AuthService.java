package com.eraasoft.spring.service;

import com.eraasoft.spring.controller.vm.AuthRequestVm;
import com.eraasoft.spring.controller.vm.AuthResponseVm;
import com.eraasoft.spring.dto.AccountDto;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {

    AuthResponseVm login(AuthRequestVm authRequestVm);
    AuthResponseVm signup(AccountDto accountDto) throws SystemException;

}
