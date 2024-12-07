package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.CustomerMaster;
import com.example.menonRetailsLtd.Services.CustomerMasterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.UUID;

@Component
@Data
public class Utilities {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();


    @Autowired
    CustomerMasterService customerMasterService;

    public String generateCartID(){
        String uniqueId = UUID.randomUUID().toString().substring(0, 8); // 8 characters from UUID
        return "MRL" + uniqueId.toUpperCase();
    }

    public String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName =  authentication.getName(); // This returns the username (or principal)
        return userName;
    }

    public String loggedInUserDetails(){
        String userName = getLoggedInUsername();
        List<CustomerMaster> customers = getUserByUserId(userName);

        if (customers != null && !customers.isEmpty()) {
            CustomerMaster c = customers.get(0); // Return the first customer if the list is not empty
            return c.getAccessId();
        }
        return null;
    }

    public String fullName(){
        String userName = getLoggedInUsername();
        List<CustomerMaster> customers = getUserByUserId(userName);

        if (customers != null && !customers.isEmpty()) {
            CustomerMaster c = customers.get(0); // Return the first customer if the list is not empty
            String fullName = c.getFirstName() + c.getLastName();
            return fullName;
        }
        return null;
    }



    public List<CustomerMaster> getUserByUserId(String AccessId){
        return customerMasterService.getCustomerByCustomerId(AccessId);
    }
}
