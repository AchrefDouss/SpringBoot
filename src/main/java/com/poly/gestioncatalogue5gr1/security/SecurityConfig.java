package com.poly.gestioncatalogue5gr1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    InMemoryUserDetailsManager InMemoryUserDetailsManager()
    {
        PasswordEncoder passwordEncoder=passwordEncoder();
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password(passwordEncoder.encode ("12345")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode ("12345")).roles("USER","ADMIN").build()
        );
    }

    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(f->f.permitAll());
httpSecurity.authorizeHttpRequests(ar->ar.requestMatchers("/user/**").hasRole("USER"));
httpSecurity.authorizeHttpRequests(ar->ar.requestMatchers("/admin/**").hasRole("ADMIN"));
         httpSecurity.authorizeHttpRequests(ar->ar.anyRequest().authenticated());
         return httpSecurity.build();
    }

}
