package com.example.backend.services;

import com.example.backend.entities.Order;
import com.example.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderByAccountId(Integer id) {
        return orderRepository.getOrderByAccountId(id);
    }
    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public void deleteOrderById(Integer id) {
        Order order = orderRepository.findById(id).get();
        if(order != null){
            orderRepository.delete(order);
        }
    }

    @Override
    public Order updateOrder(Integer id, Order order) {
        Order oldOrder = orderRepository.findById(id).get();
        if(oldOrder != null){
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public List<Order> searchUsername(String keyword) {
        return orderRepository.searchUsername(keyword);
    }

    @Override
    public List<Order> searchStatus(String keyword) {
        return orderRepository.searchStatus(keyword);
    }

    @Override
    public List<Order> searchAddress(String keyword) {
        return orderRepository.searchAddress(keyword);
    }

    @Override
    public List<Order> searchPayment(String keyword) {
        return orderRepository.searchPayment(keyword);
    }

    @Override
    public List<Order> searchPrice(BigDecimal fromPrice, BigDecimal toPrice) {
        return orderRepository.searchPrice(fromPrice,toPrice);
    }

    @Override
    public List<Order> searchToPrice(BigDecimal toPrice) {
        return orderRepository.searchToPrice(toPrice);
    }

    @Override
    public List<Order> searchFromPrice(BigDecimal fromPrice) {
        return orderRepository.searchFromPrice(fromPrice);
    }

    @Override
    public List<Order> searchDate(Instant fromDate, Instant toDate) {
        return orderRepository.searchDate(fromDate, toDate);
    }

    @Override
    public List<Order> searchToDate(Instant toDate) {
        return orderRepository.searchToDate(toDate);
    }

    @Override
    public List<Order> searchFromDate(Instant fromDate) {
        return orderRepository.searchFromDate(fromDate);
    }
}
