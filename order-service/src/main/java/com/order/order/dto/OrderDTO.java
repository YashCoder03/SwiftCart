package com.order.order.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class OrderDTO {
    private UUID id;
    private UUID userId;
    private Integer quantity;
    private BigDecimal totalAmount;
    private String orderStatus;
    private List<OrderItemDTO> items;

    // getters and setters
}
