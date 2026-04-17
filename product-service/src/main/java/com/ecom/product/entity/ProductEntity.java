package com.ecom.product.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.ecom.product.dto.ProductRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "products")
@Data
public class ProductEntity {
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(unique= false , nullable = false)
    private String name;

    @Column(unique = false, nullable= false)
    private BigDecimal price;

    @Column(unique = false, nullable = false)
    private String description;

    @Column(unique = false,nullable = false)
    private String category;

    public ProductEntity(){

    }
    
    public ProductEntity(ProductRequest productRequest){
        this.name = productRequest.getName();
        this.price = productRequest.getPrice();
        this.description = productRequest.getDescription();
        this.category = productRequest.getCategory();
    }

}
