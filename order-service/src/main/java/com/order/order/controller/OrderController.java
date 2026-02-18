package com.order.order.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.order.dto.OrderDTO;
import com.order.order.entity.OrderEntity;
import com.order.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<OrderDTO> createOrder(@PathVariable String userId){

        OrderEntity order = orderService.createOrder(userId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDTO>> getAllOrder(@PathVariable UUID userId){
        List<OrderDTO> allOrders = orderService.getAllOrders(userId);
        return ResponseEntity.ok(allOrders);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAllOrder(){
        orderService.deleteAllOrder();
        return ResponseEntity.ok("Deleted All Orders");
    }
    
}
