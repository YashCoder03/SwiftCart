package com.order.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "inventory")
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    Boolean checkStock(@PathVariable String productId);

    @PostMapping("/api/inventory/{productId}/{qty}")
    void reducesStock(@PathVariable String productId,@PathVariable Integer qty);

}
