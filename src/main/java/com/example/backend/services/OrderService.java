package com.example.backend.services;

import com.example.backend.entities.Order;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);
    public List<Order> getAllOrders();


    public List<Order> getOrderByAccountId(Integer id);
    public Order getOrderById(Integer id);

    public void deleteOrderById(Integer id);

    public Order updateOrder(Integer id, Order order);
    public List<Order> searchUsername(String keyword);
    public List<Order> searchStatus(String keyword);
    public List<Order> searchAddress(String keyword);
    public List<Order> searchPayment(String keyword);
    public List<Order> searchPrice(BigDecimal fromPrice, BigDecimal toPrice);
    public List<Order> searchToPrice(BigDecimal toPrice);
    public List<Order> searchFromPrice(BigDecimal fromPrice);
    public List<Order> searchDate(Instant fromDate, Instant toDate);
    public List<Order> searchToDate(Instant toDate);
    public List<Order> searchFromDate(Instant fromDate);
}
