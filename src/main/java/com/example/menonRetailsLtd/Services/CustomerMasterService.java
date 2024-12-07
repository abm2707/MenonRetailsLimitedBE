package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Communications.OTPGenerator;
import com.example.menonRetailsLtd.Communications.SendEmail;
import com.example.menonRetailsLtd.Models.CustomerMaster;
import com.example.menonRetailsLtd.Repositories.CustomerMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMasterService {

    @Autowired
    private CustomerMasterRepo customerMasterRepo;

    @Autowired
    @Lazy
    private SendEmail sendEmail;

    @Autowired
    private OTPGenerator otpGenerator;

    public CustomerMaster createCustomer(CustomerMaster customerMaster) {
        return customerMasterRepo.save(customerMaster);
    }

    public List<CustomerMaster> getCustomerByCustomerId(String accessId) {
        return customerMasterRepo.findByAccessId(accessId);
    }

}
