package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScreenMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer screenId;
    private String displayName;
    private String screenPath;
    private String SellerName;
}
