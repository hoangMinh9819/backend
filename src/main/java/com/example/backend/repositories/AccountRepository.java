package com.example.backend.repositories;

import com.example.backend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE CONCAT(a.username, a.firstName, a.lastName, a.email, a.gender, a.role, a.status) LIKE %?1%")
    public List<Account> searchAll(String keyword);
    @Query("SELECT a FROM Account a WHERE a.username LIKE %?1%")
    public List<Account> searchUsername(String keyword);
    @Query("SELECT a FROM Account a WHERE a.firstName LIKE %?1%")
    public List<Account> searchFirstName(String keyword);
    @Query("SELECT a FROM Account a WHERE a.lastName LIKE %?1%")
    public List<Account> searchLastName(String keyword);
    @Query("SELECT a FROM Account a WHERE a.email LIKE %?1%")
    public List<Account> searchEmail(String keyword);
    @Query("SELECT a FROM Account a WHERE a.dob >= ?1 and a.dob <= ?2")
    public List<Account> searchDob(LocalDate fromDate, LocalDate toDate);
    @Query("SELECT a FROM Account a WHERE a.dob <= ?1")
    public List<Account> searchToDob(LocalDate toDate);
    @Query("SELECT a FROM Account a WHERE a.dob >= ?1")
    public List<Account> searchFromDob(LocalDate fromDate);
    @Query("SELECT a FROM Account a WHERE a.gender LIKE ?1%")
    public List<Account> searchGender(String keyword);
    @Query("SELECT a FROM Account a WHERE a.role LIKE %?1%")
    public List<Account> searchRole(String keyword);
    @Query("SELECT a FROM Account a WHERE a.status LIKE %?1%")
    public List<Account> searchStatus(String keyword);
    @Query("SELECT a FROM Account a WHERE a.phone LIKE %?1%")
    public List<Account> searchPhone(String keyword);
}