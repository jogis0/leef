package com.treeleef.leef.services;

import com.treeleef.leef.dto.CreateOrder;
import com.treeleef.leef.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> createOrder(CreateOrder createOrder);

    Optional<List<Order>> getAllUserOrders(Long userId);
}
