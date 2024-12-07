package com.example.menonRetailsLtd.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class csrfController {

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
