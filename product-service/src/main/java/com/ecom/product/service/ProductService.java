package com.ecom.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.entity.ProductEntity;
import com.ecom.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        
        List<ProductEntity> productList = productRepository.findAll();
        return productList;
    }

    public void addProduct(ProductRequest productRequest) {

        ProductEntity productEntity = new ProductEntity(productRequest);
        productRepository.save(productEntity);

    }
}
