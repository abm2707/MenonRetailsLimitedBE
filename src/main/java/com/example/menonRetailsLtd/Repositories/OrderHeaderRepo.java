package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderHeaderRepo extends JpaRepository<OrderHeader, BigInteger> {
    List<OrderHeader> findBySellerId(String sellerId);

    @Query("SELECT claimableAmt FROM SellerMaster o WHERE o.sellerId = :sellerId")
    BigDecimal findClaimableAmountBySellerId(@Param("sellerId") String sellerId);
}
