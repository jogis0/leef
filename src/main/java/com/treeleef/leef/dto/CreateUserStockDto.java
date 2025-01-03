package com.treeleef.leef.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserStockDto {
    private Long orderId;

    private Long userId;

    private Long stockId;

    private BigInteger quantity;

    private BigDecimal price;
}
