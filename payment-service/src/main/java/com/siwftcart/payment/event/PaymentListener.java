package com.siwftcart.payment.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentListener {
    private final KafkaTemplate<String,Object> PaymentResultEventTemplate;

    @KafkaListener(topics = "order-created-topic",groupId = "swiftcart-group")
    public void handleOrderCreation(OrderEvent event){
        boolean success = Math.random() < 0.8;
        log.info("Message Recived");
        PaymentResultEvent result = new PaymentResultEvent(event.getOrderId(),success);
        PaymentResultEventTemplate.send("payment-result-topic",result);
    }
}
