package com.treeleef.leef.models;

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
@Table(name = "stocks")

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String symbol;

    private String name;

    private String exchange;

    private String currency;
}
