package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.UserRoleMapping;
import com.example.menonRetailsLtd.Services.UserRoleMappingService;
import com.example.menonRetailsLtd.SpringSecurity.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoleMappingController {

    @Autowired
    UserRoleMappingService userRoleMappingService;

    @Autowired
    JWTHelper jwtHelper;

    @GetMapping("/roleByUser")
    public String getRolesByAccessId(@RequestHeader("Authorization") String authorizationHeader) {
        System.out.println("Authorization Header is "+ authorizationHeader);
        String token = authorizationHeader.replace("Bearer ","");
        String accessId = jwtHelper.getUsernameFromToken(token);
        return userRoleMappingService.getRolesByAccessId(accessId);
    }
}
