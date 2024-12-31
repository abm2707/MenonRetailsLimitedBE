package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.mtrConfig;
import com.example.menonRetailsLtd.Repositories.MtrConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MtrConfigService {

    @Autowired
    MtrConfigRepo mtrConfigRepo;

    public Optional<mtrConfig> getEmail(String id) {
        return mtrConfigRepo.findById(1);
    }
}
