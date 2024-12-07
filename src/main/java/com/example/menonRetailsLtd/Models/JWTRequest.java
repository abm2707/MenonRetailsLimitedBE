package com.example.menonRetailsLtd.Models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class JWTRequest {
    private String emailId;
    private String password;
}
