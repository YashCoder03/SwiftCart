package com.ecom.inventory.controller;

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

import com.ecom.inventory.dto.InventoryRequest;
import com.ecom.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    
    @Autowired
    InventoryService inventoryService;

    @PostMapping("")
    private ResponseEntity<String> addStock(@RequestBody InventoryRequest inventoryRequest){
        inventoryService.addStockService(inventoryRequest);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/{productId}")
    private ResponseEntity<Boolean> isInStock(@PathVariable UUID productId){
        System.out.println(productId);
        Boolean isProductInStock = inventoryService.isInStockService(productId);
        return ResponseEntity.ok(isProductInStock);
    }

    @PostMapping("/{productId}/{qty}")
    private ResponseEntity<String> reduceStock(@PathVariable UUID productId,@PathVariable Integer qty){
        inventoryService.reduceStock(productId,qty);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{productId}")
    private ResponseEntity<String> removeStock(@PathVariable UUID productId){
        inventoryService.removeStock(productId);
        return ResponseEntity.ok("Stock Removed");

    }
}
