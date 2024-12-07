package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Communications.EmailConfigService;
import com.example.menonRetailsLtd.Communications.SendEmail;
import com.example.menonRetailsLtd.Models.CartMaster;
import com.example.menonRetailsLtd.Models.CustomerMaster;
import com.example.menonRetailsLtd.Models.EmailConfig;
import com.example.menonRetailsLtd.Services.CustomerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Client")
public class CustomerMasterController {

    @Autowired
    CustomerMasterService customerMasterService;

    @Autowired
    EmailConfigService emailConfigService;

    @Autowired
    SendEmail sendMail;

    @Autowired
    Utilities u;

    @Autowired
    CartMasterController cartMasterController;

    String resp;

    @GetMapping("/getUser/{accessId}")
    public List<CustomerMaster> getUserByUserId(@PathVariable String accessId) {
        return customerMasterService.getCustomerByCustomerId(accessId);
    }

    @PostMapping("/SignUp")
    public ResponseEntity<String> createUser(@RequestBody CustomerMaster custMaster) {
        String userName = String.valueOf(custMaster.getAccessId());
        List<CustomerMaster> existingUser = customerMasterService.getCustomerByCustomerId(userName);
        if (existingUser.isEmpty()) {
            return new ResponseEntity(customerMasterService.createCustomer(custMaster), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User Already Exists !!", HttpStatus.LOCKED);
        }
    }

    @GetMapping("/email/{templateId}")
    public Optional<EmailConfig> getEmailData(@PathVariable Long templateId) {
        return emailConfigService.getEmailBody(templateId);
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody CartMaster cartMaster){
        try {
            String userName = String.valueOf(u.loggedInUserDetails());
            String cartId = cartMaster.getCartID();

            cartMaster.setAccessId(userName);
            List<CustomerMaster> resp2 = customerMasterService.getCustomerByCustomerId(userName);
            if(!resp2.isEmpty()){
                CustomerMaster custResp = resp2.get(0);
                String cartIdVal = custResp.getCartID();
                cartMaster.setCartID(cartIdVal);
                cartMaster.setAccessId(userName);
            }
            cartMasterController.saveProductsToCart(cartMaster);
            resp = "4";
            return resp;
        } catch (Exception e) {
            resp = "5";
            return resp;
        }
    }

}
