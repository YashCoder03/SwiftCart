package com.siwftcart.payment.service;

import org.springframework.stereotype.Service;

import com.siwftcart.payment.dto.PaymentRequest;

@Service
public class PayementService {
    
    public boolean processPayment(PaymentRequest payementRequest){

        return Math.random() < 0.8;
    }

}
