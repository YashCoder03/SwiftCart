package com.order.order.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.order.dto.CartItem;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "cart")
public interface CartClient {
    

    @GetMapping("/api/cart")
    List<CartItem> getCart();


    @DeleteMapping("/api/cart")
    void deleteCart(String userId);
    
}
