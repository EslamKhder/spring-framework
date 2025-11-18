package com.spring.boot.controller;

import com.spring.boot.controller.vm.LoginRequestVM;
import com.spring.boot.controller.vm.LoginResponseVM;
import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.AuthService;
import jakarta.annotation.security.PermitAll;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseVM> login(@RequestBody LoginRequestVM requestVM) throws SystemException {
        return ResponseEntity.ok().body(authService.login(requestVM));
    }


}
