package com.treeleef.leef.services;

import com.treeleef.leef.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllUserOrders(String userId);
}
