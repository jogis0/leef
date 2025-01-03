package com.treeleef.leef.services;

import com.treeleef.leef.dto.CreateStockDto;
import com.treeleef.leef.dto.UpdateStockDto;
import com.treeleef.leef.models.Stock;

import java.util.Optional;

public interface StockService {
    Optional<Stock> createStock(CreateStockDto createStockDto);

    Optional<Stock> getStock(Long id);

    Optional<Stock> updateStock(UpdateStockDto updateStockDto);

    Optional<Stock> deleteStock(Long id);
}
