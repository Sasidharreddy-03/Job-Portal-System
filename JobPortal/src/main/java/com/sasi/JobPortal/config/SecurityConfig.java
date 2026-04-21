package com.sasi.JobPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/css/**", "/js/**").permitAll() // Unlock these
                .anyRequest().authenticated() // Lock everything else
            )
            .formLogin(form -> form
                .loginPage("/login") // Tell Spring we have a custom login page
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Disable for now so our registration form works easily

        return http.build();
    }
}