package com.example.backend.repositories;

import com.example.backend.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer> {
    @Query("SELECT oi FROM OrderItem oi WHERE oi.order.id = ?1")
    public List<OrderItem> getOrderItemByOrderId(Integer id);
}
