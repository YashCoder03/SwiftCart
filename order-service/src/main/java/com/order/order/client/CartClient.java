package com.order.order.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.order.dto.CartItem;

@FeignClient(name = "cart")
public interface CartClient {
    

    @GetMapping("/api/cart/{userId}")
    List<CartItem> getCart(@PathVariable String userId);


    @DeleteMapping("/api/cart/{userId}")
    void deleteCart(@PathVariable String userId);
    
}
