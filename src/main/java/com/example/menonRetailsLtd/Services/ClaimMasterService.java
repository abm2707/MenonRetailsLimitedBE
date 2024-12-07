package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.ClaimMaster;
import com.example.menonRetailsLtd.Repositories.ClaimMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimMasterService {

    @Autowired
    ClaimMasterRepo claimMasterRepo;

    public String saveClaimDetails(ClaimMaster claimMaster){
        claimMasterRepo.save(claimMaster);
        return "Success";
    }
}
