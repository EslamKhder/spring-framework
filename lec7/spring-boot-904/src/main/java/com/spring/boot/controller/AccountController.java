package com.spring.boot.controller;

import com.spring.boot.model.Account;
import com.spring.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/allAccounts")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @PostMapping("/account/create-account")
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);
    }


    @PutMapping("/account/edit-account")
    public void editAccount(@RequestBody Account account){
        accountService.updateAccount(account);
    }

    // /account/remove-account?accountId=5
    // /account/remove-account/5
//    @DeleteMapping("/account/remove-account")
//    public void removeAccount(@RequestParam("accountId") Long id){
    @DeleteMapping("/account/remove-account/{id}")
    public void removeAccount(@PathVariable Long id){
        accountService.removeAccount(id);
    }


    @GetMapping("/account/accountsByName/{name}")
    public List<Account> getAllAccountByName(@PathVariable String name){
        return accountService.getAllAccountByName(name);
    }


    @GetMapping("/account/search/{name}")
    public List<Account> searchByName(@PathVariable String name){
        return accountService.search(name);
    }

}
