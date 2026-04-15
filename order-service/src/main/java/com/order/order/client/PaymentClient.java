package com.order.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.order.dto.PaymentRequest;

@FeignClient(name = "payment")
public interface PaymentClient {

    @PostMapping("/api/payment")
    Boolean pay(@RequestBody PaymentRequest paymentRequest);
    
}
