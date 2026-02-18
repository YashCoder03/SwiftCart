package com.order.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;


@Data
public class OrderItemDTO {
    private UUID id;
    private String productName;
    private Integer quantity;
    private BigDecimal price;

    // getters and setters
}
