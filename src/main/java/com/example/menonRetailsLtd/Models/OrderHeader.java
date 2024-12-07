package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String sellerId;

    @Column(nullable = false)
    private Long userId; // Reference to the user who placed the order

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Double netPayable; // Total amount of the order

    @Column(nullable = false)
    private Double netTaxAmt;

    @Column(nullable = false)
    private String orderStatus; // Status of the order (e.g., 'Pending', 'Shipped', 'Delivered')

}
