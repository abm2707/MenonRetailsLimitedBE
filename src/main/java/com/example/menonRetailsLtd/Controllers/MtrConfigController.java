package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.mtrConfig;
import com.example.menonRetailsLtd.Services.MtrConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/get")
public class MtrConfigController {

    @Autowired
    MtrConfigService mtrConfigService;

    @PostMapping("/email")
    public Optional<mtrConfig> getEmail(@RequestBody String id){
        return mtrConfigService.getEmail(id);
    }

}
