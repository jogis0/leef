package com.treeleef.leef.controllers;

import com.treeleef.leef.dto.CreateUserStockDto;
import com.treeleef.leef.dto.UpdateUserStockDto;
import com.treeleef.leef.models.UserStock;
import com.treeleef.leef.services.UserStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-stocks")
public class UserStockController {
    private final UserStockService userStockService;

    public UserStockController(UserStockService userStockService) {
        this.userStockService = userStockService;
    }

    @PostMapping
    public ResponseEntity<UserStock> addUserStock(@RequestBody CreateUserStockDto createUserStockDto) {
        var result = userStockService.addUserStock(createUserStockDto);
        return result.map(userStock -> new ResponseEntity<>(userStock, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserStock>> getUserStocks(@PathVariable Long id) {
        var result = userStockService.getUserStocks(id);
        return result.map(userStock -> new ResponseEntity<>(userStock, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<UserStock> updateUserStock(@RequestBody UpdateUserStockDto updateUserStockDto) {
        var result = userStockService.updateUserStock(updateUserStockDto);
        return result.map(userStock -> new ResponseEntity<>(userStock, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserStock> deleteUserStocks(@PathVariable Long id) {
        var result = userStockService.deleteUserStock(id);
        return result.map(userStock -> new ResponseEntity<>(userStock, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
