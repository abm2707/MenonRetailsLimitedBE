package com.example.menonRetailsLtd.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class OperatorMaster {
    private final String status = "ACTIVE";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operatorId; // Unique identifier for the operator
    private String username; // Username for the operator
    private String password; // Password for the operator (ensure proper hashing in practice)
    private String firstName; // First name of the operator
    private String lastName; // Last name of the operator
    private String email; // Email address of the operator
    private String phoneNumber; // Contact number of the operator
    private LocalDateTime createdAt; // Timestamp when the operator was created
    private LocalDateTime updatedAt; // Timestamp when the operator record was last updated
}
