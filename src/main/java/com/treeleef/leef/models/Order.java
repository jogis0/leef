package com.treeleef.leef.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import com.treeleef.leef.models.enumerators.OrderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private OrderType type;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(nullable = false)
    private BigInteger amount;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Timestamp creationDate;
}
