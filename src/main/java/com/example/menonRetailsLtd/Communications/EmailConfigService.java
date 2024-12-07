package com.example.menonRetailsLtd.Communications;

import com.example.menonRetailsLtd.Models.EmailConfig;
import com.example.menonRetailsLtd.Repositories.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailConfigService {
    @Autowired
    EmailRepo emailRepo;

    public Optional<EmailConfig> getEmailBody(Long templateId) {
        return emailRepo.findById(templateId);
    }
}
