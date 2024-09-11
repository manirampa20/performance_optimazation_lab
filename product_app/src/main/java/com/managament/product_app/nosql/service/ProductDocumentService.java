package com.managament.product_app.nosql.service;

import com.managament.product_app.nosql.model.ProductDocument;
import com.managament.product_app.nosql.repository.ProductDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDocumentService {
    @Autowired
    private ProductDocumentRepository productDocumentRepository;

    @Cacheable(value = "products", key = "#root.methodName")
    public List<ProductDocument> getAllProducts() {
        return productDocumentRepository.findAll();
    }

    @Cacheable(value = "products", key = "#id")
    public Optional<ProductDocument> getProductById(String id) {
        return productDocumentRepository.findById(id);
    }

    @CachePut(value = "products", key = "#product.id")
    public ProductDocument saveProduct(ProductDocument product) {
        return productDocumentRepository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProductById(String id) {
        productDocumentRepository.deleteById(id);
    }
}
