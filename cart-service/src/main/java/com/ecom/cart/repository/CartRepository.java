package com.ecom.cart.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.cart.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, UUID>{
    
}
