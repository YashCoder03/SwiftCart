package com.order.order.event;

import org.springframework.stereotype.Component;

import com.order.order.entity.OrderEntity;
import com.order.order.entity.OrderStatus;
import com.order.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderListener {

    private final OrderRepository orderRepository;
    
    public void handlePaymentResult(PaymentResultEvent event){

        OrderEntity order = orderRepository.findById(event.getOrderId())
                                        .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + event.getOrderId())); 

        if(event.isSuccess()){
            order.setOrderStatus(OrderStatus.CONFIRMED);
        }
        else{
            order.setOrderStatus(OrderStatus.CANCELLED);
        }
        orderRepository.save(order);
    }
    
}
