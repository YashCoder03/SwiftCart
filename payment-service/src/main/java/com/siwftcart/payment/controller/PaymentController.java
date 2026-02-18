package com.siwftcart.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siwftcart.payment.dto.PaymentRequest;
import com.siwftcart.payment.service.PayementService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    PayementService paymentService;

    @PostMapping("")
    public ResponseEntity<Boolean> makePayement(@RequestBody PaymentRequest paymentRequest){
        Boolean check = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(check);
    }
}
