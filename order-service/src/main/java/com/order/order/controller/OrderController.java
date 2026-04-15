package com.order.order.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.order.dto.OrderDTO;
import com.order.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDTO> createOrder(@RequestHeader("X-User-Id") String userId){

        OrderDTO order = orderService.createOrder(userId);
        return ResponseEntity.ok(order);
    }

    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAllOrder(@RequestHeader("X-User-Id") String userId){
        List<OrderDTO> allOrders = orderService.getAllOrders(UUID.fromString(userId));
        return ResponseEntity.ok(allOrders);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllOrder(){
        orderService.deleteAllOrder();
        return ResponseEntity.ok("Deleted All Orders");
    }
    
}
