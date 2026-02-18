package com.siwftcart.payment.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;


@Data
public class PaymentRequest {
    private UUID userId;
    private BigDecimal amount;
}
