package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScreenAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer screenKey;
    private Integer screenId;
    private Integer Role;
    private String status;
}
