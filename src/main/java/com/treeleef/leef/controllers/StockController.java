package com.treeleef.leef.controllers;

import com.treeleef.leef.dto.CreateStockDto;
import com.treeleef.leef.dto.UpdateStockDto;
import com.treeleef.leef.models.Stock;
import com.treeleef.leef.services.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {this.stockService = stockService;}

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody CreateStockDto createStockDto) {
        var result = stockService.createStock(createStockDto);
        return result.map(stock -> new ResponseEntity<>(stock, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable Long id) {
        var result = stockService.getStock(id);
        return result.map(stock -> new ResponseEntity<>(stock, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<Stock> updateStock(@RequestBody UpdateStockDto updateStockDto) {
        var result = stockService.updateStock(updateStockDto);
        return result.map(stock -> new ResponseEntity<>(stock, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable Long id) {
        var result = stockService.deleteStock(id);
        return result.map(stock -> new ResponseEntity<>(stock, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
