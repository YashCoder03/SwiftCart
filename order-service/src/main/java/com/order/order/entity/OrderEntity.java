package com.order.order.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;
    
    private UUID userId;

    private BigDecimal totalAmount;
    
    private OrderStatus orderStatus;

    @OneToMany(mappedBy= "order",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItemEntity> item;

}
