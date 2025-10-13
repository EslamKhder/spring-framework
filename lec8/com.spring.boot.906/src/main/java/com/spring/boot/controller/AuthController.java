package com.spring.boot.controller;

import com.spring.boot.controller.vm.AuthRequestVm;
import com.spring.boot.controller.vm.AuthResponseVm;
import com.spring.boot.dto.StudentDto;
import com.spring.boot.service.AuthService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;


    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    ResponseEntity<AuthResponseVm> login(@RequestBody @Valid AuthRequestVm authRequestVm) throws SystemException {
        return ResponseEntity.ok(authService.login(authRequestVm));
    }

    @PostMapping("/signup")
    ResponseEntity<AuthResponseVm> signup(@RequestBody @Valid StudentDto accountDto) throws SystemException {
        return ResponseEntity.ok(authService.signup(accountDto));
    }
}
