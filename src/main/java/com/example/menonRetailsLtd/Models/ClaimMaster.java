package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ClaimMaster {
    @Id
    private String claimId;
    private String sellerId;
    private BigDecimal claimAmt;
    private Date claimDate;
    private String claimedBy;
}
