package com.spring.demo.controller;


import com.spring.demo.controller.vm.LoginResponseVM;
import com.spring.demo.dto.AccountDto;
import com.spring.demo.dto.TeacherDto;
import com.spring.demo.service.AccountService;
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
@RequestMapping("/api")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseVM> login(@RequestBody AccountDto accountDto) throws SystemException {
        return ResponseEntity.ok(accountService.login(accountDto));
//        return teacherService.createTeacher(teacherDto);
    }

//    @PostMapping("/signup")
//    public ResponseEntity<TeacherDto> signup(@RequestBody AccountDto accountDto) {
//        return ResponseEntity.created(new URI("/api/save")).body(teacherService.createTeacher(teacherDto));
////        return teacherService.createTeacher(teacherDto);
//    }
}
