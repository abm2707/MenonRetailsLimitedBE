package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class SellerMaster {

    @Id
    private String sellerId;
    private String registeredOwner;
    private String sellerName;
    private String gstRegNo;
    private String activationStatus;
    private BigDecimal claimableAmt;
}
