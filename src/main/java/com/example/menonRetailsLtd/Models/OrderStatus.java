package com.example.menonRetailsLtd.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String UserIdentifier;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
