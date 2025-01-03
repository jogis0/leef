package com.treeleef.leef.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStockDto {
    private Long id;

    private String symbol;

    private String name;

    private String currency;
}
