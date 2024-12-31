package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.userMaster;
import com.example.menonRetailsLtd.Repositories.UserRepository;
import com.example.menonRetailsLtd.Controllers.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    String encryptedPassword;

    @Autowired
    UserRepository userRepository;
    Utilities utilities = new Utilities();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userMaster user = userRepository.findByaccessId(username);
        System.out.println("Authenticating user: " + username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found !!");
        }
        return new org.springframework.security.core.userdetails.User(user.getAccessId(), user.getPassword(), new ArrayList<>());
    }

    public userMaster createUser(userMaster user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (user != null) {
            encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
        }
        assert user != null;

        String cartID = utilities.generateCartID();
        if(cartID != null){
            user.setCartId(cartID);
        }
        return userRepository.save(user);
    }
}
