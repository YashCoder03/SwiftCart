package com.ecom.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ecom.cart.dto.CartItemRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CartService {

    private final RedisTemplate<String,Object> redisTemplate;

    private String getCartKey(String userId){
        return "Cart : " + userId;
    }
 
    public void addCart(String userId, CartItemRequest cartItemRequest){

        String key = this.getCartKey(userId);
        System.out.println(cartItemRequest.toString());


        List<CartItemRequest> list = (List<CartItemRequest>) redisTemplate.opsForValue().get(key);

        if(list == null) {
            list = new ArrayList<>();
        }

        list.add(cartItemRequest);

        redisTemplate.opsForValue().set(key, list);

    }

    public void clearCart(String userId){
        String key = this.getCartKey(userId);

        redisTemplate.delete(key);
    }

    public List<CartItemRequest> getCart(String userId){

        String key = this.getCartKey(userId);

        List<CartItemRequest> list = (List<CartItemRequest>) redisTemplate.opsForValue().get(key);

        System.out.println(list.toString());

        return list;
    }
    
}
