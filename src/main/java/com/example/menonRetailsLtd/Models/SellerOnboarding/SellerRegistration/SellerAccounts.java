package com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SellerAccounts {

    @Id
    private Long sellerid;

    private String bankAccountName;

    private String bankAccountNumber;

    private String ifscCode;

    private String bankName;

    private String branchName;

    private String upiId;

    private String panNumber;

    private String stateRegion;

    private String taxIdentificationNumber;
}
