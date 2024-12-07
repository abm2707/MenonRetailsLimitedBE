package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.ClaimMaster;
import com.example.menonRetailsLtd.Models.CustomerMaster;
import com.example.menonRetailsLtd.Models.SellerMaster;
import com.example.menonRetailsLtd.Services.SellerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/Seller")
public class SellerMasterController {

    @Autowired
    private SellerMasterService sellerMasterService;

    @Autowired
    private OrderHeaderController orderHeaderController;

    @Autowired
    private ClaimController claimController;

    Utilities utilities = new Utilities();

    @GetMapping("/SignUp")
    public String SellerRegistration(@RequestBody SellerMaster sellerMaster) {
        try {
            sellerMasterService.createSeller(sellerMaster);
            return "Seller Registration Successful !!";
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during seller registration: " + e.getMessage());
        }
    }

    @PutMapping("/updateDetails")
    public String UpdateSellerDetails(@RequestBody SellerMaster sellerMaster) {
        try {
            sellerMasterService.updateSellerDetails(sellerMaster);
            return "Seller Details updated Successfully !!";
        } catch (RuntimeException e) {
            throw new RuntimeException("An error occurred while updating seller details: " + e.getMessage());
        }
    }

    @PostMapping("/claim/{sellerId}")
    public ResponseEntity<String> claimAmount(@PathVariable String sellerId, @RequestBody SellerMaster sellerMaster) {
        try {
            // Retrieve claimable amount
            BigDecimal claimableAmount = orderHeaderController.getclaimableAmount(sellerId);
            BigDecimal enteredAmt = sellerMaster.getClaimableAmt();

            // Validate claim amount
            if (claimableAmount.compareTo(enteredAmt) < 0) {
                return new ResponseEntity<>("Claim amount exceeds available amount", HttpStatus.BAD_REQUEST);
            }

            // Generate claim details
            String claimId = ClaimController.generateClaimId();
            String resp2 = utilities.fullName();

            if (resp2 != null) {
                String claimedBy = resp2;
                ClaimMaster claim = new ClaimMaster();

                // Set claim data
                claim.setClaimId(claimId);
                claim.setClaimAmt(enteredAmt);
                claim.setSellerId(sellerId);
                claim.setClaimedBy(claimedBy);
                claim.setClaimDate(new Date()); // Use current date for each claim

                // Save claim
                claimController.saveClaimDetails(claim);
            }

            return new ResponseEntity<>("Return Code: 1", HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>("An error occurred while processing the claim: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
