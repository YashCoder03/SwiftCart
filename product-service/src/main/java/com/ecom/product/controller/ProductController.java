package com.ecom.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.entity.ProductEntity;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        List<ProductEntity> productList = productService.getAllProducts();  
        return ResponseEntity.ok().body(productList);
    }

    @PostMapping("")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {

        productService.addProduct(productRequest);
        return ResponseEntity.ok("Created");
    }
    
}
