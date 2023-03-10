package com.example.backend.services;

import com.example.backend.dto.LoginRequestDTO;
import com.example.backend.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);

    public List<Account> getAllAccounts();
    public List<Account> getAllAdmins();
    public List<Account> getAllUsers();

    public Account getAccountById(Integer id);

    public void deleteAccountById(Integer id);

    public Account updateAccount(Integer id, Account account);

    public List<Account> searchAll(String keyword);

    public List<Account> searchUsername(String keyword);

    public List<Account> searchFirstName(String keyword);

    public List<Account> searchLastName(String keyword);

    public List<Account> searchEmail(String keyword);

    public List<Account> searchDob(LocalDate fromDate, LocalDate toDate);

    public List<Account> searchToDob(LocalDate toDate);

    public List<Account> searchFromDob(LocalDate fromDate);

    public List<Account> searchGender(String keyword);

    public List<Account> searchRole(String keyword);

    public List<Account> searchStatus(String keyword);
    public List<Account> searchPhone(String keyword);

    public Account getAdminLogin(LoginRequestDTO loginRequestDTO);
    public Account getUserLogin(LoginRequestDTO loginRequestDTO);
}

