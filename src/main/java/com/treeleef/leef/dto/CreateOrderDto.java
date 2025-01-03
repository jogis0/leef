package com.treeleef.leef.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {
    private Long userId;

    private String type;

    private Long stockId;

    private BigInteger amount;

    private BigDecimal price;
}
