package com.treeleef.leef.services;

import com.treeleef.leef.models.Order;
import com.treeleef.leef.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllUserOrders(String userId) {
        return orderRepository.findAllByUserId(Long.getLong(userId));
    }
}
