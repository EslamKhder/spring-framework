package com.spring.boot.controller;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.exceptions.IdMisMatchException;
import com.spring.boot.service.AccountService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/allAccount")
    public ResponseEntity<List<AccountDto>> getApplications(){
        return ResponseEntity.ok(accountService.getApplications());
    }

    @PostMapping("/addAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody @Valid AccountDto account) throws SystemException, IdMisMatchException {
        return ResponseEntity.created(URI.create("/addAccount")).body(accountService.createAccount(account));
    }

    @PutMapping("/updateAccount")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto account) throws SystemException {
        return ResponseEntity.ok(accountService.updateAccount(account));
    }

    @DeleteMapping("/deleteAccount")
    //http://localhost:7070/account/deleteAccount?custom_id=5  @RequestParam
    //http://localhost:7070/account/deleteAccount/5  @PathVariable
    public ResponseEntity<Void> deleteAccount(@RequestParam("custom_id") Long id) throws SystemException {
        return accountService.deleteAccount(id) ?
                    ResponseEntity.noContent().build() :
                            ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<AccountDto>> search(@RequestParam String key) throws SystemException {
        return ResponseEntity.ok(accountService.search(key));
    }

    @GetMapping("/search/phone")
    public ResponseEntity<List<AccountDto>> searchByPhone(@RequestParam String phone) throws SystemException {
        return ResponseEntity.ok(accountService.getByPhone(phone));
    }
}
