package com.spring.boot908.controller;


import com.spring.boot908.controller.vm.LoginRequestVM;
import com.spring.boot908.controller.vm.LoginResponseVM;
import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.service.AuthService;
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


    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody @Valid TeacherDto teacherDto) throws SystemException {
        authService.signUp(teacherDto);
        return ResponseEntity.created(URI.create("/auth/sign-up")).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseVM> login(@RequestBody @Valid LoginRequestVM loginRequestVM) throws SystemException{
        return ResponseEntity.ok(authService.login(loginRequestVM));
    }
}
