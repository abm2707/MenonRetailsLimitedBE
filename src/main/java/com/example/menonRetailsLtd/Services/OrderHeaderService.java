package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.OrderHeader;
import com.example.menonRetailsLtd.Repositories.OrderHeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderHeaderService {

    @Autowired
    OrderHeaderRepo orderHeaderRepo;

    public List<OrderHeader> getTransactionBySellerId(String sellerId) {
        return orderHeaderRepo.findBySellerId(sellerId);
    }

    public BigDecimal findClaimableAmountBySellerId(String sellerId) {
        return orderHeaderRepo.findClaimableAmountBySellerId(sellerId);
    }
}
