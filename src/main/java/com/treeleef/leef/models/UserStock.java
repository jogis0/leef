package com.treeleef.leef.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class UserStock {
    private Long orderId;

    private Long userId;

    private Long stockId;

    private BigInteger quantity;

    private BigDecimal price;

    private Timestamp date;
}
