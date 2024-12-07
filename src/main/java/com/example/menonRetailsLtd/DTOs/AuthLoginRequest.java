package com.example.menonRetailsLtd.DTOs;

import lombok.Data;

@Data
public class AuthLoginRequest {
    private String enteredOtp;
    private String generatedOtp;
    private String accessId;
}
