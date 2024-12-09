package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration.SellerAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SellerAccountsRepo extends JpaRepository<SellerAccounts, BigInteger> {

}
