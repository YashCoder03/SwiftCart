package com.ecom.product.controller;

import java.util.List;
import java.util.UUID;

import com.ecom.product.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.entity.ProductEntity;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        List<ProductEntity> productList = productService.getAllProducts();  
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @PostMapping("")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {

        productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }

    @GetMapping("/{productId}")
    public  ResponseEntity<ApiResponse<ProductEntity>> getProductById(@PathVariable  UUID productId){
        ProductEntity entity = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                HttpStatus.OK.value(),
                "Fetched Successfully",
                entity
        ));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId){
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductEntity>> updateProductById(@PathVariable UUID productId,@RequestBody ProductRequest product){

        ProductEntity entity = productService.updateProduct(productId,product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<ProductEntity>(
                HttpStatus.ACCEPTED.value(),
                "Update Successfully",
                entity
        ));

    }
    
}
