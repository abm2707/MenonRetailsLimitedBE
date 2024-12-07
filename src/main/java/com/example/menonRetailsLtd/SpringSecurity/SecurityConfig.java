package com.example.menonRetailsLtd.SpringSecurity;

import com.example.menonRetailsLtd.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JWTAthenticationEntryPoint jwtAthenticationEntryPoint;

    @Autowired
    JWTAuthenticationFilter jwtAuthenticationFilter;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // Use cookies for CSRF
//                // Set custom header name
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("getToken/Csrf").permitAll() // Allow access to CSRF endpoint
//                        .anyRequest().authenticated()) // Require authentication for all other requests
//                .httpBasic(withDefaults()) // Login security via postman
//                .formLogin(withDefaults()); // Use basic authentication // Login security via webpage
//
//        return http.build();
//    }

//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> {
//            User user = userRepository.findByUsername(username);
//            if (user != null) {
//                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//            } else {
//                throw new UsernameNotFoundException("User not found");
//            }
//        }).passwordEncoder(passwordEncoder());
//    }

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for development; enable in production
                .cors(Customizer.withDefaults()) // Enable CORS; relies on CorsConfigurationSource bean
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/Client/**", "/client/register", "/client/test",
                                "/screenAccess/screens/**", "/auth/login", "/auth/login/authLogin",
                                "/addPrdToCart/add", "/login").permitAll() // Permit login, register, and test pages
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/static/**").permitAll() // Permit static resources
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .logout(LogoutConfigurer::permitAll)
                .httpBasic(Customizer.withDefaults());

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Allow specific origin
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow specific HTTP methods
        configuration.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
        configuration.setAllowCredentials(true); // Allow cookies (if needed)
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply CORS to all endpoints
        return source;
    }

}
