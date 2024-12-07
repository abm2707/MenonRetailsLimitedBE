package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Communications.EmailConfigService;
import com.example.menonRetailsLtd.Models.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/getEmail")
public class EmailConfigController {

    @Autowired
    EmailConfigService emailConfigService;

    public Optional<EmailConfig> getEmailData(Long templateId) {
        return emailConfigService.getEmailBody(templateId);
    }
}
