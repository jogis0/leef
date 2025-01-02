package com.treeleef.leef.services.implementations;

import com.treeleef.leef.dto.CreateOrderDto;
import com.treeleef.leef.models.Order;
import com.treeleef.leef.models.enumerators.OrderType;
import com.treeleef.leef.repositories.OrderRepository;
import com.treeleef.leef.repositories.UserRepository;
import com.treeleef.leef.services.OrderService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {this.orderRepository = orderRepository; this.userRepository = userRepository;}

    @Override
    public Optional<Order> createOrder(CreateOrderDto createOrderDto) {
        var user = userRepository.findById(createOrderDto.getUserId());
        if (user.isEmpty())
            return Optional.empty();

        var order = Order.builder()
                .user(user.get())
                .type(OrderType.valueOf(createOrderDto.getType()))
                .ticker(createOrderDto.getTicker())
                .amount(createOrderDto.getAmount())
                .price(createOrderDto.getPrice())
                .creationDate(Timestamp.from(Instant.now()))
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
