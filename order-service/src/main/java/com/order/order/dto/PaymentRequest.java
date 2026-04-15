package com.order.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PaymentRequest {
    private UUID userId;
    private BigDecimal amount;
    public PaymentRequest(UUID userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
