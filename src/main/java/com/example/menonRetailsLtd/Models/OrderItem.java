package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private Long productId; // Reference to the product


    private String brandName;


    private String productName;


    private Integer quantity; // Number of units ordered

    private Double price; // Price of each unit


    private Double GrossAmount; // Total price for this item (quantity * price)


    private Double TaxAmt;


    private Double NetPayable;

}
