package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.SellerMaster;
import com.example.menonRetailsLtd.Repositories.SellerMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerMasterService {

    @Autowired
    SellerMasterRepo sellerMasterRepo;

    public String createSeller(SellerMaster sellerMaster) {
        return sellerMasterRepo.save(sellerMaster).toString();
    }

    public String updateSellerDetails(SellerMaster sellerMaster) {
        return sellerMasterRepo.save(sellerMaster).toString();
    }
}
