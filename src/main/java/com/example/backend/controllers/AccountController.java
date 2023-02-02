package com.example.backend.controllers;

import com.example.backend.entities.Account;
import com.example.backend.repositories.AccountRepository;
import com.example.backend.services.AccountService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Account>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Integer id, @RequestBody Account account) {
        return new ResponseEntity<Account>(accountService.updateAccount(id, account), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Account>> searchLike(
            @RequestParam("keyword") @Nullable String keyword,
            @RequestParam("column") String column,
            @RequestParam("fromDate") @Nullable LocalDate fromDate,
            @RequestParam("toDate") @Nullable LocalDate toDate
    ) {
        switch (column) {
            case "all":
                return ResponseEntity.ok(accountService.searchAll(keyword));
            case "role":
                return ResponseEntity.ok(accountService.searchRole(keyword));
            case "username":
                return ResponseEntity.ok(accountService.searchUsername(keyword));
            case "firstName":
                return ResponseEntity.ok(accountService.searchFirstName(keyword));
            case "lastName":
                return ResponseEntity.ok(accountService.searchLastName(keyword));
            case "email":
                return ResponseEntity.ok(accountService.searchEmail(keyword));
            case "gender":
                return ResponseEntity.ok(accountService.searchGender(keyword));
            case "status":
                return ResponseEntity.ok(accountService.searchStatus(keyword));
            case "phone":
                return ResponseEntity.ok(accountService.searchPhone(keyword));
            case "dob":
                if (fromDate != null && toDate != null) {
                    return ResponseEntity.ok(accountService.searchDob(fromDate, toDate));
                } else if (fromDate == null && toDate != null) {
                    return ResponseEntity.ok(accountService.searchToDob(toDate));
                } else if (toDate == null && fromDate != null) {
                    return ResponseEntity.ok(accountService.searchFromDob(fromDate));
                } else {
                    return ResponseEntity.ok(accountService.getAllAccounts());
                }
            default:
                return ResponseEntity.ok(accountService.getAllAccounts());
        }
    }
}
