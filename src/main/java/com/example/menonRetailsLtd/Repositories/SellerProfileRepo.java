package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration.Sellerprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SellerProfileRepo extends JpaRepository<Sellerprofile, BigInteger> {
}
