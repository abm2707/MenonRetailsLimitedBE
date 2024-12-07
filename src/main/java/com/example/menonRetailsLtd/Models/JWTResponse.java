package com.example.menonRetailsLtd.Models;

import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Builder
public class JWTResponse {
    private String JWTToken;
    private String email;
}
