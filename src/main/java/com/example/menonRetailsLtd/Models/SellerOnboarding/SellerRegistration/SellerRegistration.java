package com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

@Entity
@Data
public class SellerRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sellerId")
    private Long sellerId;

    private String businessName;

    private String ownerName;

    private String businessType;

    private String phoneNumber;

    private String address;

    private String emailAddress;

    private String pinZipCode;

    private String stateRegion;

    private String country;
}
