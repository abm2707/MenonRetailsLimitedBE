package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.ErrorCodeMaster;
import com.example.menonRetailsLtd.Repositories.ErrorMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ErrorMasterService {

    @Autowired
    ErrorMasterRepo errorMasterRepo;

    public Optional<ErrorCodeMaster> getErrorByCode(Integer errId) {
        return errorMasterRepo.findById(errId);
    }
}
