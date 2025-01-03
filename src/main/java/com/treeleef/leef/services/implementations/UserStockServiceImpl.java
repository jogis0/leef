package com.treeleef.leef.services.implementations;

import com.treeleef.leef.dto.CreateUserStockDto;
import com.treeleef.leef.dto.UpdateUserStockDto;
import com.treeleef.leef.models.UserStock;
import com.treeleef.leef.repositories.OrderRepository;
import com.treeleef.leef.repositories.StockRepository;
import com.treeleef.leef.repositories.UserRepository;
import com.treeleef.leef.repositories.UserStockRepository;
import com.treeleef.leef.services.UserStockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStockServiceImpl implements UserStockService {
    private final UserStockRepository userStockRepository;

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final StockRepository stockRepository;

    public UserStockServiceImpl(UserStockRepository userStockRepository, OrderRepository orderRepository, UserRepository userRepository, StockRepository stockRepository) {
        this.userStockRepository = userStockRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public Optional<UserStock> addUserStock(CreateUserStockDto createUserStockDto) {
        var order = orderRepository.findById(createUserStockDto.getOrderId());
        var user = userRepository.findById(createUserStockDto.getUserId());
        var stock = stockRepository.findById(createUserStockDto.getStockId());

        if (order.isEmpty() || user.isEmpty() || stock.isEmpty())
            return Optional.empty();

        var userStock = UserStock.builder()
                .order(order.get())
                .user(user.get())
                .stock(stock.get())
                .quantity(createUserStockDto.getQuantity())
                .price(createUserStockDto.getPrice())
                .build();

        userStockRepository.save(userStock);
        return Optional.of(userStock);
    }

    @Override
    public Optional<List<UserStock>> getUserStocks(Long id) {
        if (userRepository.existsById(id))
            return Optional.of(userStockRepository.findAllByUserId(id));
        return Optional.empty();
    }

    @Override
    public Optional<UserStock> updateUserStock(UpdateUserStockDto updateUserStockDto) {
        var order = orderRepository.findById(updateUserStockDto.getOrderId());
        var user = userRepository.findById(updateUserStockDto.getUserId());
        var stock = stockRepository.findById(updateUserStockDto.getStockId());

        if (order.isEmpty() || user.isEmpty() || stock.isEmpty())
            return Optional.empty();

        var userStock = UserStock.builder()
                .id(updateUserStockDto.getId())
                .order(order.get())
                .user(user.get())
                .stock(stock.get())
                .quantity(updateUserStockDto.getQuantity())
                .price(updateUserStockDto.getPrice())
                .build();

        userStockRepository.save(userStock);
        return Optional.of(userStock);
    }

    @Override
    public Optional<UserStock> deleteUserStock(Long id) {
        if (userStockRepository.existsById(id)) {
            var userStock = userStockRepository.findById(id);
            userStockRepository.deleteById(id);
            return userStock;
        }
        return Optional.empty();
    }
}
