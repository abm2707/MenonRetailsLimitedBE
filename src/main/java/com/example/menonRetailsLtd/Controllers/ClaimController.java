package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.ClaimMaster;
import com.example.menonRetailsLtd.Repositories.ClaimMasterRepo;
import com.example.menonRetailsLtd.Services.ClaimMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    ClaimMasterService claimMasterService;

    private static final AtomicInteger claimCounter = new AtomicInteger(0); // Auto-incrementing counter

    // Method to generate a claim ID
    public static String generateClaimId() {
        String finYear = getFinancialYear(); // Get the financial year
        int nextClaimNumber = claimCounter.incrementAndGet(); // Increment and get the next claim number
        String claimId = finYear + String.format("%06d", nextClaimNumber); // Combine finYear with 6-digit claim number
        return claimId;
    }

    // Method to calculate the financial year
    private static String getFinancialYear() {
        LocalDate currentDate = LocalDate.now(); // Get the current date
        int currentYear = currentDate.getYear(); // Current year
        int nextYear = currentYear + 1; // Next year

        // If the current month is before April (i.e., before the start of the financial year)
        if (currentDate.getMonthValue() < 4) {
            return (currentYear - 1) + "-" + String.format("%02d", currentYear % 100); // Previous year to current year
        } else { // From April onwards, use the current year to next year
            return currentYear + "-" + String.format("%02d", nextYear % 100);
        }
    }


    public String saveClaimDetails(ClaimMaster claimMaster){
        claimMasterService.saveClaimDetails(claimMaster);
        return "Success";
    }
}
