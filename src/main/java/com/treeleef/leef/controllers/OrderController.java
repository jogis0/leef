package com.treeleef.leef.controllers;

import com.treeleef.leef.dto.CreateOrder;
import com.treeleef.leef.models.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrder createOrder) {}
}
