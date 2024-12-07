package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.OrderHeader;
import com.example.menonRetailsLtd.Services.OrderHeaderService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Trans")
public class OrderHeaderController {

    @Autowired
    OrderHeaderService orderHeaderService;

    @GetMapping("/{sellerId}")
    public List<OrderHeader> getTransactionBySellerId(@PathVariable String sellerId) {
        return orderHeaderService.getTransactionBySellerId(sellerId);
    }

    @GetMapping("/getAmt/{sellerId}")
    public BigDecimal getclaimableAmount(@PathVariable String sellerId) {
        return orderHeaderService.findClaimableAmountBySellerId(sellerId);
    }
}
