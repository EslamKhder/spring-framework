package com.spring.boot.controller.auth;

import com.spring.boot.controller.vm.TokenResponseVm;
import com.spring.boot.dto.AccountDto;
import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.dto.exception.IdNotNullException;
import com.spring.boot.service.AuthService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody @Valid EmployeeDto employeeDto) throws SystemException, IdNotNullException {
        authService.signUp(employeeDto);
        return ResponseEntity.created(URI.create("/auth/sign-up")).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseVm> login(@RequestBody @Valid EmployeeDto employeeDto) throws SystemException{
        return ResponseEntity.ok(authService.login(employeeDto));
    }


}
