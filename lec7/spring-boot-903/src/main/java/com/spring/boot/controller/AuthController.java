package com.spring.boot.controller;

import com.spring.boot.controller.vm.AccountRequestVm;
import com.spring.boot.controller.vm.AccountResponseVm;
import com.spring.boot.dto.AccountDto;
import com.spring.boot.exceptions.IdMisMatchException;
import com.spring.boot.service.AuthService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AccountResponseVm> login(@RequestBody @Valid AccountRequestVm accountRequestVm)  {
        return ResponseEntity.created(URI.create("/craete-account")).body(authService.login(accountRequestVm));
    }

    @PostMapping("/create-account")
    public ResponseEntity<AccountResponseVm> signup(@RequestBody @Valid AccountDto account) {
        return ResponseEntity.created(URI.create("/craete-account")).body(authService.addAccount(account));
    }

}
