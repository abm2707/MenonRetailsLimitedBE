package com.example.menonRetailsLtd.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getToken")
@EnableWebSecurity
public class DummyClass {


    @GetMapping("/Csrf")
    public CsrfToken getcsrfToken(HttpServletRequest request) {

        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        if (csrfToken == null) {
            System.out.println("No CSRF token found");
        } else {
            System.out.println("CSRF Token: " + csrfToken.getToken());
        }

        return csrfToken;
    }
}
