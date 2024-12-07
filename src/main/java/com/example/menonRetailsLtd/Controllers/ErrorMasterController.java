package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.ErrorCodeMaster;
import com.example.menonRetailsLtd.Services.ErrorMasterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ErrorMasterController {

    @Autowired
    ErrorMasterService errorMasterService;

    public String getErrorByCode(Integer errId) {
        String errorDesc;
        Optional<ErrorCodeMaster> resp = errorMasterService.getErrorByCode(errId);
        try {
            ErrorCodeMaster err = resp.get();
            errorDesc = err.getErrorDesc();
            return errorDesc;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
