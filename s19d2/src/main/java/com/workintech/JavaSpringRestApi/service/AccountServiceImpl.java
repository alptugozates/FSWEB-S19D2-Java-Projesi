package com.workintech.JavaSpringRestApi.service;

import com.workintech.JavaSpringRestApi.entity.Account;
import com.workintech.JavaSpringRestApi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
@Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    private List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account getAccountById(Long id) {
        return accounts.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void createAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void updateAccount(Long id, Account newAccount) {
        Account existingAccount = getAccountById(id);
        if (existingAccount != null) {
            existingAccount.setName(newAccount.getName());
            existingAccount.setPassword(newAccount.getPassword());
        }
    }

    @Override
    public void deleteAccount(Long id) {
        Optional<Account> optionalAccount = accounts.stream().filter(a -> a.getId().equals(id)).findFirst();
        optionalAccount.ifPresent(account -> accounts.remove(account));
    }


}
