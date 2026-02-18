package com.ecom.inventory.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Inventory")
@Data
public class InventoryEntity {

    InventoryEntity(){

    }

    @Id
    @Column(nullable= false , unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ; 

    @Column(nullable=false)
    private UUID productId;

    @Column(nullable=false)
    private Integer quantity;

    public InventoryEntity(UUID productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void reducesQty(Integer qty){
        this.quantity -= qty;
    }

    
    
}
