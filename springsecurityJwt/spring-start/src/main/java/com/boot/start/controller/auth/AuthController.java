package com.boot.start.controller.auth;

import com.boot.start.dto.TokenResponse;
import com.boot.start.dto.UserDto;
import com.boot.start.model.Student;
import com.boot.start.service.auth.AuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    ResponseEntity<TokenResponse> login(@RequestBody UserDto userDto) throws SystemException {
        return ResponseEntity.ok(authService.login(userDto));
    }

}
