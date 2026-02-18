package com.ecom.cart.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cart.dto.CartItemRequest;
import com.ecom.cart.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/{userId}")
    private ResponseEntity<String> addCart(@PathVariable String userId ,@RequestBody CartItemRequest cartItemRequest){

        cartService.addCart(userId,cartItemRequest);
        return ResponseEntity.ok("Added in Cart");
    }

    @GetMapping("/{userId}")
    private ResponseEntity<List<CartItemRequest>> getCart(@PathVariable String userId){

        List<CartItemRequest> list= cartService.getCart(userId);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{userId}")
    private ResponseEntity<String> clearCart(@PathVariable String userId){

        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart Cleared");
    }
}
