package com.spring.controller;


import com.spring.config.jwt.TokenHandler;
import com.spring.dto.UserLoginDto;
import com.spring.service.UserAuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("/login")
    ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) throws SystemException {
        return ResponseEntity.ok(userAuthService.login(userLoginDto));
    }

}
