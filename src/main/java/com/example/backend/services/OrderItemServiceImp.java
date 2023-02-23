package com.example.backend.services;

import com.example.backend.entities.OrderItem;
import com.example.backend.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemServiceImp implements OrderItemService{
    @Autowired
    OrderItemRepository orderItemRepository;
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(Integer id) {
        return orderItemRepository.getOrderItemByOrderId(id);
    }

    @Override
    public void deleteOrderItemById(Integer id) {
        OrderItem orderItem = orderItemRepository.findById(id).get();
        if(orderItem != null){
            orderItemRepository.delete(orderItem);
        }
    }

    @Override
    public OrderItem updateOrderItem(Integer id, OrderItem orderItem) {
        OrderItem oldOrderItem = orderItemRepository.findById(id).get();
        if(oldOrderItem != null){
            orderItem.setId(id);
            return orderItemRepository.save(orderItem);
        }
        return null;
    }
}
