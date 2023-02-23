package com.example.backend.services;

import com.example.backend.entities.OrderItem;

import java.util.List;

public interface OrderItemService {
    public OrderItem createOrderItem(OrderItem orderItem);

    public List<OrderItem> getOrderItemByOrderId(Integer id);

    public void deleteOrderItemById(Integer id);

    public OrderItem updateOrderItem(Integer id, OrderItem orderItem);
}
