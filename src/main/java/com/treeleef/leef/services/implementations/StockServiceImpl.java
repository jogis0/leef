package com.treeleef.leef.services.implementations;

import com.treeleef.leef.dto.CreateStockDto;
import com.treeleef.leef.dto.UpdateStockDto;
import com.treeleef.leef.models.Stock;
import com.treeleef.leef.repositories.StockRepository;
import com.treeleef.leef.services.StockService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {this.stockRepository = stockRepository;}

    @Override
    public Optional<Stock> createStock(CreateStockDto createStockDto) {
        var stock = Stock.builder()
                .symbol(createStockDto.getSymbol())
                .name(createStockDto.getName())
                .currency(createStockDto.getCurrency())
                .build();

        stockRepository.save(stock);
        return Optional.of(stock);
    }

    @Override
    public Optional<Stock> getStock(Long id) {
        if (stockRepository.existsById(id)) {
            return stockRepository.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Stock> updateStock(UpdateStockDto updateStockDto) {
        if (stockRepository.existsById(updateStockDto.getId())) {
            var stock = Stock.builder()
                    .id(updateStockDto.getId())
                    .symbol(updateStockDto.getSymbol())
                    .name(updateStockDto.getName())
                    .currency(updateStockDto.getCurrency())
                    .build();

            stockRepository.save(stock);
            return Optional.of(stock);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Stock> deleteStock(Long id) {
        if (stockRepository.existsById(id)) {
            var stock = stockRepository.findById(id);
            stockRepository.deleteById(id);
            return stock;
        }
        return Optional.empty();
    }
}
