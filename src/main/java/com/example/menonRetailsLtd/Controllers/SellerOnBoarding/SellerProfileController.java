package com.example.menonRetailsLtd.Controllers.SellerOnBoarding;

import com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration.SellerAccounts;
import com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration.Sellerprofile;
import com.example.menonRetailsLtd.Services.SellerOnBoardingServices.SellerOnBoardingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class SellerProfileController {

    String errResp;

    @Autowired
    SellerOnBoardingServices sellerOnBoardingServices;

    @PostMapping("/profile")
    public String RegisterVendorProfile(@RequestBody Sellerprofile sellerprofile){
        try {
            Long sellerId = sellerOnBoardingServices.registerSellerProfile(sellerprofile);
            errResp = "8"+","+sellerId;
            return errResp;
        } catch (RuntimeException e) {
            errResp = "9";
            return errResp;
            //comment
        }
    }

    @PostMapping("/accounts")
    public String RegisterVendor(@RequestBody SellerAccounts sellerAccounts){
        try {
            sellerOnBoardingServices.registerSellerAccounts(sellerAccounts);
            errResp = "8";
            return errResp;
        } catch (RuntimeException e) {
            errResp = "9";
            return errResp;
        }
    }
}
