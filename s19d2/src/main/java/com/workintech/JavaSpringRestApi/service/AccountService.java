package com.workintech.JavaSpringRestApi.service;

import com.workintech.JavaSpringRestApi.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    void createAccount(Account account);
    void updateAccount(Long id, Account newAccount);
    void deleteAccount(Long id);
}
