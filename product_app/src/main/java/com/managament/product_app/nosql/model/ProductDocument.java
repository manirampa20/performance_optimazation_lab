package com.managament.product_app.nosql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductDocument {

    @Id
    private String id;

    @Indexed(unique = true)  // Create a unique index on the 'name' field to ensure unique product names
    private String name;

    private String description;

    @Indexed  // Create a non-unique index on the 'price' field to speed up price-based queries
    private double price;

    @Indexed  // Create a non-unique index on the 'categoryId' field to speed up queries filtering by category
    private String categoryId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
