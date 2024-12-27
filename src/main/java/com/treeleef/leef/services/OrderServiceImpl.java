package com.treeleef.leef.services;

import com.treeleef.leef.dto.CreateOrder;
import com.treeleef.leef.models.Order;
import com.treeleef.leef.models.enumerators.OrderType;
import com.treeleef.leef.repositories.OrderRepository;
import com.treeleef.leef.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {this.orderRepository = orderRepository; this.userRepository = userRepository;}

    @Override
    public Optional<Order> createOrder(CreateOrder createOrder) {
        var user = userRepository.findById(createOrder.getUserId());
        if (user.isEmpty())
            return Optional.empty();

        var order = Order.builder()
                .user(user.get())
                .type(OrderType.valueOf(createOrder.getType()))
                .ticker(createOrder.getTicker())
                .amount(createOrder.getAmount())
                .price(createOrder.getPrice())
                .build();

        return Optional.of(orderRepository.save(order));
    }

    @Override
    public Optional<List<Order>> getAllUserOrders(Long userId) {
        if (userRepository.existsById(userId))
            return Optional.of(orderRepository.findAllByUserId(userId));
        return Optional.empty();
    }
}
