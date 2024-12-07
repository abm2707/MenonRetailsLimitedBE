package com.example.menonRetailsLtd.Controllers.SellerOnBoarding;

import com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration.SellerRegistration;
import com.example.menonRetailsLtd.Services.SellerOnBoardingServices.SellerOnBoardingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class SellerProfileController {
//Push to github
    String errResp;

    @Autowired
    SellerOnBoardingServices sellerOnBoardingServices;

    @PostMapping("/profile")
    public String RegisterVendorProfile(@RequestBody SellerRegistration sellerRegistration){
        try {
            Long sellerId = sellerOnBoardingServices.registerSellerProfile(sellerRegistration);
            errResp = "8"+","+sellerId;
            return errResp;
        } catch (RuntimeException e) {
            errResp = "9";
            return errResp;
        }
    }

    @PostMapping("/accounts")
    public String RegisterVendor(@RequestBody SellerRegistration sellerRegistration){
        try {
            sellerOnBoardingServices.registerSellerAccounts(sellerRegistration);
            errResp = "8";
            return errResp;
        } catch (RuntimeException e) {
            errResp = "9";
            return errResp;
        }
    }
}
