package com.eraasoft.spring.controller;

import com.eraasoft.spring.dto.AccountDto;
import com.eraasoft.spring.dto.EraaSoftSchoolDto;
import com.eraasoft.spring.service.AccountService;
import com.eraasoft.spring.service.EraaSoftSchoolService;
import com.eraasoft.spring.service.token.TokenHandler;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;
    private TokenHandler tokenHandler;

    @Autowired
    public AccountController(AccountService accountService, TokenHandler tokenHandler) {
        this.accountService = accountService;
        this.tokenHandler = tokenHandler;
    }

    @GetMapping("/user")
    ResponseEntity<AccountDto> getStudentById(@RequestParam String userName) {
        return ResponseEntity.ok(accountService.getByUserName(userName));
    }

}
