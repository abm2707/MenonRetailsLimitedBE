package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.DTOs.ScreenModel;
import com.example.menonRetailsLtd.Models.CustomerMaster;
import com.example.menonRetailsLtd.Models.JWTResponse;
import com.example.menonRetailsLtd.Models.UserRoleMapping;
import com.example.menonRetailsLtd.Models.userMaster;
import com.example.menonRetailsLtd.Services.CustomUserDetailsService;
import com.example.menonRetailsLtd.Services.CustomerMasterService;
import com.example.menonRetailsLtd.SpringSecurity.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
//@RequestMapping("/client")
public class UserController {
    String fullName;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    CustomerMasterService customerMasterService;

    @Autowired
    ScreenAccessController screenAccessController;

    @Autowired
    UserRoleMappingController userRoleMappingController;

    @Autowired
    JWTHelper jwtHelper;

    @GetMapping("/client/login")
    public String login() {
        return "loginpage";
    }

    @GetMapping("/client/register")
    public String register() {
        return "Register";
    }

//    @GetMapping("/client/test")
//    public String test() {
//        return "test"; // This should return test.html from templates
//    }

    @PostMapping("/client/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        System.out.println("Login Creds: " + username + " " + password);
        if (username == null || username.isEmpty()) {
            System.out.println("Username is missing or empty!");
            return "redirect:/error"; // Handle error if username is missing
        }

        System.out.println("Redirecting to: /home?username=" + username);
        return "redirect:/home?username=" + username; // Redirecting with query parameter
    }

    @GetMapping("/home")
    public String home(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // System.out.println("Role of User"+ roleOfUser);

        String username = authentication.getName();
        System.out.println("Logged in User" + username);
        List<CustomerMaster> CustomerData = customerMasterService.getCustomerByCustomerId(username);
        if (!CustomerData.isEmpty()) {
            CustomerMaster customer = CustomerData.get(0);

            String firstName = customer.getFirstName();
            String lastName = customer.getLastName();
            fullName = firstName + " " + lastName;
        }
        model.addAttribute("fullName", fullName);

        //List<UserRoleMapping> Roles = userRoleMappingController.getRolesByAccessId(username);

        Set<Object[]> accessibleScreens = new HashSet<>();

        /*for (UserRoleMapping role : Roles) {
            List<Object[]> screensForRole = screenAccessController.getAccessibleScreens(Integer.valueOf(role.getRole()));
            accessibleScreens.addAll(screensForRole);
        } */

        List<ScreenModel> screenModels = new ArrayList<>();
        for (Object[] screenData : accessibleScreens) {
            String screenName = (String) screenData[1]; // Assuming the screen name is the first element
            String screenPath = (String) screenData[2]; // Assuming the screen path is the second element
            screenModels.add(new ScreenModel(screenName, screenPath));
        }

        // Add to model
        model.addAttribute("accessibleScreens", screenModels);

        return "home"; // This serves the home.html template
    }

    @PostMapping("/client/signUp")
    public String signUpUser(@RequestBody userMaster user) {
        customUserDetailsService.createUser(user);
        return "redirect:/client/login"; // Redirect to the login page or appropriate page
    }

    @GetMapping("/logout")
    public String loggingOut() {
        return "loginpage";
    }

    @GetMapping("/ClaimView")
    public String getAboutPage(Model model) {
        return "ClaimView"; // Maps to about.html in templates folder
    }



}
