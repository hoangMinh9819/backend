package com.example.backend.controllers;

import com.example.backend.entities.OrderItem;
import com.example.backend.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderitem")
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderItem>> getOrderItemByOrderId(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<OrderItem>>(orderItemService.getOrderItemByOrderId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        return new ResponseEntity<OrderItem>(orderItemService.createOrderItem(orderItem), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable("id") Integer id, @RequestBody OrderItem
            orderItem) {
        return new ResponseEntity<OrderItem>(orderItemService.updateOrderItem(id, orderItem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable("id") Integer id) {
        orderItemService.deleteOrderItemById(id);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }
}

