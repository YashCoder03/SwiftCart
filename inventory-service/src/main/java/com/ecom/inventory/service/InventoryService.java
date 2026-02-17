package com.ecom.inventory.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.inventory.dto.InventoryRequest;
import com.ecom.inventory.entity.InventoryEntity;
import com.ecom.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
    
    @Autowired
    InventoryRepository inventoryRepository;

    public void addStockService(InventoryRequest inventoryRequest){
        
        InventoryEntity inventoryEntity = new InventoryEntity(inventoryRequest.getProductId(),inventoryRequest.getQuantity());

        inventoryRepository.save(inventoryEntity);

    }

    public Boolean isInStockService(UUID productId){

        Boolean check = inventoryRepository.existsByProductId(productId);
        return check;
    }
}
