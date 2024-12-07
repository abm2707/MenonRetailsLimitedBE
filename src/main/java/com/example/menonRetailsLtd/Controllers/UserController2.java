package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Communications.SendEmail;
import com.example.menonRetailsLtd.DTOs.AuthLoginRequest;
import com.example.menonRetailsLtd.Models.JWTRequest;
import com.example.menonRetailsLtd.Models.JWTResponse;
import com.example.menonRetailsLtd.Models.userMaster;
import com.example.menonRetailsLtd.Services.UserMasterService;
import com.example.menonRetailsLtd.SpringSecurity.JWTHelper;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController2 {

    @Autowired
    JWTHelper jwtHelper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    SendEmail sendEmail;

    @Autowired
    UserMasterService userMasterService;

    String resp, loggedInUser, respVal, generatedOtp, accessId;

    private static Logger logger = LoggerFactory.getLogger(UserController2.class);

    @PostMapping("/login")
    public String login(@RequestBody JWTRequest request) throws MessagingException {

        // Authenticate entered username and pass
        doAuthenticate(request.getEmailId(), request.getPassword());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if authentication is valid
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            loggedInUser = authentication.getName(); // Returns the username
        }
        sendEmail.sendOTP(1L, request.getEmailId());
        generatedOtp = sendEmail.otpResp();
        return generatedOtp;
    }

    @PostMapping("/login/authLogin")
    public String authenticateOtp(@RequestBody AuthLoginRequest authLoginRequest){
        String genOtp = authLoginRequest.getGeneratedOtp();
        String entOtp = authLoginRequest.getEnteredOtp();
        String accId = authLoginRequest.getAccessId();
        System.out.println("Generated OTP:"+genOtp);
        System.out.println("Entered OTP:"+entOtp);
        System.out.println("Access Id:"+accId);

        if (entOtp.equals(genOtp)) {
            resp = "6";
            ResponseEntity<JWTResponse> jwtResponse = returnJWTToken(resp, accId);
            JWTResponse jwtBody = jwtResponse.getBody();
            if(jwtBody != null) {
                String jwtToken = jwtBody.getJWTToken();
                return jwtToken;
            }
        }
            resp = "7";
            return resp;
    }

    public ResponseEntity<JWTResponse> returnJWTToken(String resp, String accessId) {
        if (resp.equals("6")) {
            // If the response is OK, then generate JWT Token.
            UserDetails userDetails = userDetailsService.loadUserByUsername(accessId);
            String token = jwtHelper.generateToken(userDetails);
            JWTResponse response = JWTResponse.builder()
                    .JWTToken(token)
                    .email(userDetails.getUsername()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        resp = "2";
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }


    public void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);
            resp = "OK";
            logger.error("Reponse after autentication is: "+resp);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }
    public void getUserRolesByAccessId(String accessId){

    }

    @PostMapping("/UserDataByLoggedUser")
    public List<Object[]> getLoggedInUSerDetails(@RequestBody userMaster req){
        logger.info("Fetching User Details !!!");
        if(req != null){
             accessId = req.getAccessId();
        }
        return userMasterService.getUserDetails(accessId);
    }

}
