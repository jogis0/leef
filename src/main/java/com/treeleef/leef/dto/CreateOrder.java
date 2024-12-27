package com.treeleef.leef.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CreateOrder {
    private Long userId;
    private String type;

    private String ticker;

    private BigInteger amount;

    private BigDecimal price;

    public CreateOrder(Long userId, String type, String ticker, BigInteger amount, BigDecimal price) {
        this.userId = userId;
        this.type = type;
        this.ticker = ticker;
        this.amount = amount;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public String getTicker() {
        return ticker;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
