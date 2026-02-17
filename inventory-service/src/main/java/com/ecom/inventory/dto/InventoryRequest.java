package com.ecom.inventory.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class InventoryRequest {

    private UUID productId;
    private Integer quantity; 
}
