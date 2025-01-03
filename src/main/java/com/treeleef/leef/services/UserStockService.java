package com.treeleef.leef.services;

import com.treeleef.leef.dto.CreateUserStockDto;
import com.treeleef.leef.dto.UpdateUserStockDto;
import com.treeleef.leef.models.UserStock;

import java.util.List;
import java.util.Optional;

public interface UserStockService {
    Optional<UserStock> addUserStock(CreateUserStockDto createUserStockDto);

    Optional<List<UserStock>> getUserStocks(Long id);

    Optional<UserStock> updateUserStock(UpdateUserStockDto updateUserStockDto);

    Optional<UserStock> deleteUserStock(Long id);
}
