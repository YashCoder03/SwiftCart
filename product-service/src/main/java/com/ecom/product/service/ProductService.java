package com.ecom.product.service;

import java.util.List;
import java.util.UUID;

import com.ecom.product.exception.ResourceNotFoundException;
import com.ecom.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.dto.ProductRequest;
import com.ecom.product.entity.ProductEntity;
import com.ecom.product.repository.ProductRepository;

@Service
public class ProductService {

    final private ProductRepository productRepository;
    final private ProductMapper instance;
    public ProductService(ProductRepository productRepository, ProductMapper instance) {
        this.productRepository = productRepository;
        this.instance = instance;
    }

    public List<ProductEntity> getAllProducts(){
        
        List<ProductEntity> productList = productRepository.findAll();
        return productList;
    }

    public void addProduct(ProductRequest productRequest) {

        ProductEntity productEntity = new ProductEntity(productRequest);
        productRepository.save(productEntity);

    }

    public ProductEntity getProductById(UUID productId){
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product Id Not Found"));
    }

    public void deleteProductById(UUID productId){
        productRepository.deleteById(productId);
    }

    public ProductEntity updateProduct(UUID productId,ProductRequest product) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));

         instance.updateEntityFromDto(product,productEntity);

        productEntity = productRepository.save(productEntity);
        return productEntity;
    }
}
