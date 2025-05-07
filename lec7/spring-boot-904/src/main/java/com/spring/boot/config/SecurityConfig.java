package com.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/account/allAccounts").hasRole("ADMIN");

        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.withUsername("ahmed")
                .password("{bcrypt}$2a$12$ClGL4/kKKMuJCW0ocRJkuOuqcGHgHn03aUPASgISpd6NtK7W3.gtq")
                .roles("USER","ADMIN").build();
        UserDetails user2 = User.withUsername("eslam")
                .password("{bcrypt}$2a$12$j3Hl8CFhjYwcSxqTcGdN.O.bwxdeNNBp0jNTA1R1ZKT3GKWYy4yXa")
                .roles("USER").build();
        UserDetails user3 = User.withUsername("mona")
                .password("{bcrypt}$2a$12$/TsaMRUtqFQ7lg7vMSwoZOcpcLvW/ZaxKr89O7NeCQSGgWG0cd2eC")
                .roles("USER", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
