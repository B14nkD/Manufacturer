package com.example.Manufacturer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private String description;
    private String imageUrl;
    private double price;
    private double discount;
    private String manufacturerId; // Reference to Manufacturer

    // Getters and setters
}
