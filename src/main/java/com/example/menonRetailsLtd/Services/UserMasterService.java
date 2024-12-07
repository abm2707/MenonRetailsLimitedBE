package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.userMaster;
import com.example.menonRetailsLtd.Repositories.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMasterService {

    @Autowired
    UserMasterRepo userMasterRepo;

    public List<Object[]> getUserDetails(String accessId) {
        return userMasterRepo.findUserDetails(accessId);
    }
}
