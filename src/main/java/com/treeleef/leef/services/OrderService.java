package com.treeleef.leef.services;

import com.treeleef.leef.dto.CreateOrderDto;
import com.treeleef.leef.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> createOrder(CreateOrderDto createOrderDto);

    Optional<List<Order>> getAllUserOrders(Long userId);
}
