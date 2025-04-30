package com.spring.boot.controller;

import com.spring.boot.controller.vm.AccountResponseVm;
import com.spring.boot.dto.AccountDto;
import com.spring.boot.model.Account;
import com.spring.boot.service.AccountService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/allAccounts")
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }

//    @GetMapping("/account/specAccounts")
//    public ResponseEntity<List<AccountResponseVm>> getAllAccount(){
//        return ResponseEntity.ok(accountService.getAllAccount());
//    }


    @PostMapping("/account/create-account")
    public ResponseEntity<Void> createAccount(@RequestBody @Valid AccountDto account) throws SystemException {
        accountService.createAccount(account);
        return ResponseEntity.created(URI.create("/account/create-account")).build();
    }


    @PutMapping("/account/edit-account")
    public ResponseEntity<AccountDto> editAccount(@RequestBody AccountDto account) throws SystemException {
        return ResponseEntity.ok(accountService.updateAccount(account));
    }

    // /account/remove-account?accountId=5
    // /account/remove-account/5
//    @DeleteMapping("/account/remove-account")
//    public void removeAccount(@RequestParam("accountId") Long id){
//    @DeleteMapping("/account/remove-account/{id}")
//    public void removeAccount(@PathVariable Long id){
//        accountService.removeAccount(id);
//    }
    // account/remove-account
    @DeleteMapping("/account/remove-account")
    public ResponseEntity<Void> removeAccount(@RequestParam Long id) throws SystemException {
        accountService.removeAccount(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/account/accountsByName/{name}")
    public List<AccountDto> getAllAccountByName(@PathVariable String name){
        return accountService.getAllAccountByName(name);
    }


    @GetMapping("/account/search/{name}")
    public List<AccountDto> searchByName(@PathVariable String name){
        return accountService.search(name);
    }

}
