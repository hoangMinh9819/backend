package com.example.backend.services;

import com.example.backend.entities.Account;
import com.example.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void deleteAccountById(Integer id) {
        Account account = accountRepository.findById(id).get();
        if(account != null){
            accountRepository.delete(account);
        }
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        Account oldAccount = accountRepository.findById(id).get();
        if(oldAccount != null){
            account.setId(id);
            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    public List<Account> searchAll(String keyword) {
        return accountRepository.searchAll(keyword);
    }

    @Override
    public List<Account> searchUsername(String keyword) {
        return accountRepository.searchUsername(keyword);
    }

    @Override
    public List<Account> searchFirstName(String keyword) {
        return accountRepository.searchFirstName(keyword);
    }

    @Override
    public List<Account> searchLastName(String keyword) {
        return accountRepository.searchLastName(keyword);
    }

    @Override
    public List<Account> searchEmail(String keyword) {
        return accountRepository.searchEmail(keyword);
    }

    @Override
    public List<Account> searchDob(LocalDate fromDate, LocalDate toDate) {
        return accountRepository.searchDob(fromDate,toDate);
    }

    @Override
    public List<Account> searchToDob(LocalDate toDate) {
        return accountRepository.searchToDob(toDate);
    }

    @Override
    public List<Account> searchFromDob(LocalDate fromDate) {
        return accountRepository.searchFromDob(fromDate);
    }

    @Override
    public List<Account> searchGender(String keyword) {
        return accountRepository.searchGender(keyword);
    }

    @Override
    public List<Account> searchRole(String keyword) {
        return accountRepository.searchRole(keyword);
    }

    @Override
    public List<Account> searchStatus(String keyword) {
        return accountRepository.searchStatus(keyword);
    }

    @Override
    public List<Account> searchPhone(String keyword) {
        return accountRepository.searchPhone(keyword);
    }

}
