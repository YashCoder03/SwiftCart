package com.ecom.cart.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "cart")
@Data
public class CartEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    @Column(nullable=false)
    private UUID productId;
    
    @Column(nullable=false)
    private Integer quantity;
}
