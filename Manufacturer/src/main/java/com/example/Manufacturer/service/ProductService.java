package com.example.Manufacturer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
