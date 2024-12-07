package com.example.menonRetailsLtd.Services.SellerOnBoardingServices;

import com.example.menonRetailsLtd.Models.SellerOnboarding.SellerRegistration.SellerRegistration;
import com.example.menonRetailsLtd.Repositories.SellerAccountsRepo;
import com.example.menonRetailsLtd.Repositories.SellerProfileRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerOnBoardingServices {

    @Autowired
    SellerProfileRepo sellerOnBoardingRepo;

    @Autowired
    SellerAccountsRepo sellerAccountsRepo;

    private static final Logger logger = LoggerFactory.getLogger(SellerOnBoardingServices.class);

    // This api returns response code with sellerId from DB.
    public Long registerSellerProfile(SellerRegistration sellerRegistration) {
        try{
           SellerRegistration sellerResp =  sellerOnBoardingRepo.save(sellerRegistration);
            Long sellerId = sellerResp.getSellerId();
            logger.info("Saved Seller Profile Successfully !!");
            return sellerId;
        } catch (RuntimeException e) {
            logger.error(String.valueOf(e));
        }
        return null;
    }

    public void registerSellerAccounts(SellerRegistration sellerRegistration) {
        try{
            sellerAccountsRepo.save(sellerRegistration);
        } catch (RuntimeException e) {
            logger.error("Error while saving Seller Accounts:"+e);
        }
    }
}
