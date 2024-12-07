package com.example.menonRetailsLtd.Communications;

import com.example.menonRetailsLtd.Models.CustomerMaster;
import com.example.menonRetailsLtd.Models.EmailConfig;
import com.example.menonRetailsLtd.Repositories.CustomerMasterRepo;
import com.example.menonRetailsLtd.Services.CustomerMasterService;
import com.example.menonRetailsLtd.Controllers.EmailConfigController;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/AccountControl")
public class SendEmail {

    String resp;

    @Autowired
    private EmailConfigController emailConfigController;

    @Autowired
    private OTPGenerator otpGenerator;

    @Autowired
    private CustomerMasterRepo customerMasterRepo;

    @Autowired
    private CustomerMasterService customerMasterService;

    @Autowired
    private JavaMailSender emailSender;

    private String bodyToSend;
    private String fromEmailWithName;
    private String toMail, fromEmail, subject, otp;

    // Email Body Formatter
    public String EmailBodyFormatter(Long templateId, String accessId) {
        otp = otpGenerator.generateOTP();
        Optional<EmailConfig> resp = emailConfigController.getEmailData(templateId);
        if (resp.isPresent()) {
            EmailConfig emailConfig = resp.get();
            toMail = accessId;
            fromEmail = emailConfig.getFromEmail();
            fromEmailWithName = "Menon Retails Ltd. <" + fromEmail + ">";
            subject = emailConfig.getSubject();
            bodyToSend = emailConfig.getEmailHeader() + emailConfig.getEmailBody() + emailConfig.getEmailFooter();
            bodyToSend = bodyToSend.replace("##OTP", otp);
            return bodyToSend;
        }
        return null;
    }

    public String otpResp(){
        String otpRespVal = otp;
        return otpRespVal;
    }

    // OTP Authentication
    @PostMapping("/login/deactivate")
    public ResponseEntity<String> authenticateOtp(String generatedOtp, String enteredOtp, String accessId) throws MessagingException {
        if (generatedOtp.equalsIgnoreCase(enteredOtp)) {
            // Making User Inactive
            List<CustomerMaster> customers = customerMasterService.getCustomerByCustomerId(accessId);
            if (!customers.isEmpty()) {
                CustomerMaster customer = customers.get(0);
                customer.setOtp("");
                customer.setStatus("InActive");
                customerMasterRepo.save(customer);
            }

            // Send mail to user
            sendOTP(1L, accessId);
            resp = "6";
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } else {
            resp = "7";
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
    }

    // Delete Account Logic
    public String deleteAccount(String accessId) throws MessagingException {
        return sendOTP(1L, accessId);
    }

    // Send OTP via Email
    public String sendOTP(Long templateId, String accessId) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String setText = EmailBodyFormatter(templateId, accessId);
        helper.setTo(toMail);
        helper.setSubject(subject);
        helper.setFrom(fromEmailWithName);
        helper.setText(bodyToSend, true);
        emailSender.send(message);

        // Fetch and update OTP for customer
        List<CustomerMaster> customers = customerMasterService.getCustomerByCustomerId(accessId);
        if (!customers.isEmpty()) {
            CustomerMaster customer = customers.get(0);
            customer.setOtp(otp);
            customerMasterRepo.save(customer);
        }
        return "Email Sent to User's registered Email address!";
    }

    @DeleteMapping("/DeleteAccount/{accessId}")
    public ResponseEntity<String> initiateAccountDeletion(@PathVariable String accessId) {
        try {
            deleteAccount(accessId);
            return new ResponseEntity<>("Deletion initiated successfully!", HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/DeleteAccount/{accessId}/Confirm")
    public ResponseEntity<String> confirmAccountDeletion(
            @PathVariable String accessId, @RequestBody SendEmail genOtp, @RequestBody EmailConfig enteredOtp) {
        try {
            String result = confirmAccountDeletionLogic(accessId, genOtp, enteredOtp);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String confirmAccountDeletionLogic(String accessId, SendEmail genOtp, EmailConfig enteredOtp) throws MessagingException {
        authenticateOtp(genOtp.toString(), enteredOtp.toString(), accessId);
        return accessId;
    }

}
