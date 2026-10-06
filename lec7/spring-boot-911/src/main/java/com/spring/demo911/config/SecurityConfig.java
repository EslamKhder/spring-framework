package com.spring.demo911.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource source){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(source);
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/players/**").hasAllRoles("ADMIN", "MANAGER")
                .anyRequest().authenticated());

        http.httpBasic(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails1 =
//                User.withUsername("eslam").password("{bcrypt}$2a$12$xaCX8Oq3SLu2.8tUm.AyHuuyMuBidq7KIugA.Q49l25K0PP80QkSy").roles("ADMIN", "MANAGER", "USER").build();
//        UserDetails userDetails2 =
//                User.withUsername("ahmed").password("{bcrypt}$2a$12$8n1AP4Lx77iBBYUxtWrok.7dGTZXEAltVHZ7aeceFaLaxU4wXz.DS").roles("MANAGER", "USER").build();
//        UserDetails userDetails3 =
//                User.withUsername("mona").password("{bcrypt}$2a$12$yqanaEqKgekyT.fUng1IbOT5D6DB6IdCPW2AtcQT4x3k.iK6GP/iK").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
