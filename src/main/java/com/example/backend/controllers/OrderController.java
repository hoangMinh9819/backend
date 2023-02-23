package com.example.backend.controllers;

import com.example.backend.entities.Ingredient;
import com.example.backend.entities.Order;
import com.example.backend.services.OrderService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
    }
    @GetMapping("/account/{id}")
    public ResponseEntity<List<Order>> getOrderByAccountId(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<Order>>(orderService.getOrderByAccountId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Integer id, @RequestBody Order
            order) {
        return new ResponseEntity<Order>(orderService.updateOrder(id, order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id) {
        orderService.deleteOrderById(id);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Order>> searchLike(
            @RequestParam("keyword") @Nullable String keyword,
            @RequestParam("column") String column,
            @RequestParam("fromPrice") @Nullable BigDecimal fromPrice,
            @RequestParam("toPrice") @Nullable BigDecimal toPrice,
            @RequestParam("fromDate") @Nullable Instant fromDate,
            @RequestParam("toDate") @Nullable Instant toDate
    ) {
        switch (column) {
            case "username":
                return ResponseEntity.ok(orderService.searchUsername(keyword));
            case "status":
                return ResponseEntity.ok(orderService.searchStatus(keyword));
            case "address":
                return ResponseEntity.ok(orderService.searchAddress(keyword));
            case "payment":
                return ResponseEntity.ok(orderService.searchPayment(keyword));
            case "price":
                if (fromPrice != null && toPrice != null) {
                    return ResponseEntity.ok(orderService.searchPrice(fromPrice, toPrice));
                } else if (fromPrice == null && toPrice != null) {
                    return ResponseEntity.ok(orderService.searchToPrice(toPrice));
                } else if (toPrice == null && fromPrice != null) {
                    return ResponseEntity.ok(orderService.searchFromPrice(fromPrice));
                } else {
                    return ResponseEntity.ok(orderService.getAllOrders());
                }
            case "date":
                if (fromDate != null && toDate != null) {
                    return ResponseEntity.ok(orderService.searchDate(fromDate, toDate));
                } else if (fromDate == null && toDate != null) {
                    return ResponseEntity.ok(orderService.searchToDate(toDate));
                } else if (toDate == null && fromDate != null) {
                    return ResponseEntity.ok(orderService.searchFromDate(fromDate));
                } else {
                    return ResponseEntity.ok(orderService.getAllOrders());
                }
            default:
                return ResponseEntity.ok(orderService.getAllOrders());
        }
    }
}
