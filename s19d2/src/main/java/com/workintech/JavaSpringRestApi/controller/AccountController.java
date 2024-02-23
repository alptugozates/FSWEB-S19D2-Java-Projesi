package com.workintech.JavaSpringRestApi.controller;

import com.workintech.JavaSpringRestApi.entity.Account;
import com.workintech.JavaSpringRestApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/")
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account newAccount) {
        accountService.updateAccount(id, newAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

}
