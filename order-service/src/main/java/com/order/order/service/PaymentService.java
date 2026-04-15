package com.order.order.service;

import org.springframework.stereotype.Service;

import com.order.order.client.PaymentClient;
import com.order.order.dto.PaymentRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClient paymentClient;


    @CircuitBreaker(name = "paymentService",fallbackMethod = "paymentFallback")
    public Boolean callPayment(PaymentRequest paymentRequest){
        return paymentClient.pay(paymentRequest);
    }

    public Boolean paymentFallback(PaymentRequest paymentRequest,Throwable ex){
        return false;
    }

    
}
