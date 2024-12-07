package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class ProductMaster {
    private final String status = "ACTIVE";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    private String Brand;
    private String productName; // Name of the product
    private String Category; // Product Category
    private String productDescription; // Description of the product
    private BigDecimal price; // Price of the product
    private Integer stockQuantity; // Available stock quantity
    private LocalDateTime createdAt; // Timestamp for when the product was created
    private LocalDateTime updatedAt; // Timestamp for when the product record was last updated
}
