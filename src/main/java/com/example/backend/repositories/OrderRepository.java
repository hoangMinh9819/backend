package com.example.backend.repositories;

import com.example.backend.entities.Account;
import com.example.backend.entities.Ingredient;
import com.example.backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.account.id = ?1")
    public List<Order> getOrderByAccountId(Integer id);

    @Query("SELECT o FROM Order o WHERE o.id = ?1")
    public Order getOrderById(Integer id);

    @Query("SELECT o FROM Order o WHERE o.account.username LIKE %?1%")
    public List<Order> searchUsername(String keyword);

    @Query("SELECT o FROM Order o WHERE o.status LIKE %?1%")
    public List<Order> searchStatus(String keyword);

    @Query("SELECT o FROM Order o WHERE o.address LIKE %?1%")
    public List<Order> searchAddress(String keyword);

    @Query("SELECT o FROM Order o WHERE o.paymentType LIKE %?1%")
    public List<Order> searchPayment(String keyword);

    @Query("SELECT o FROM  Order o WHERE o.totalPrice >= ?1 and o.totalPrice <= ?2")
    public List<Order> searchPrice(BigDecimal fromPrice, BigDecimal toPrice);

    @Query("SELECT o FROM  Order o WHERE o.totalPrice <= ?1")
    public List<Order> searchToPrice(BigDecimal toPrice);

    @Query("SELECT o FROM  Order o WHERE o.totalPrice >= ?1")
    public List<Order> searchFromPrice(BigDecimal fromPrice);

    @Query("SELECT o FROM Order o WHERE o.createAt >= ?1 and o.createAt <= ?2")
    public List<Order> searchDate(Instant fromDate, Instant toDate);

    @Query("SELECT o FROM Order o WHERE o.createAt <= ?1")
    public List<Order> searchToDate(Instant toDate);

    @Query("SELECT o FROM Order o WHERE o.createAt >= ?1")
    public List<Order> searchFromDate(Instant fromDate);
}
