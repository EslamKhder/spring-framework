package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }

    // http://localhost:9091/api/teachers  POST
    // http://localhost:9091/api/teachers  GET
    // http://localhost:9091/api/teachers  PUT
    // http://localhost:9091/api/teachers  DELETE
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrf -> csrf.disable());
//        http.authorizeHttpRequests(api -> api.requestMatchers(HttpMethod.GET, "/api/teachers").hasAllRoles("MANGER","ADMIN"));
        http.authorizeHttpRequests(api -> api.requestMatchers("/api/login").permitAll());
        http.authorizeHttpRequests(api -> api.requestMatchers("/api/signup").permitAll());
        http.authorizeHttpRequests(api -> api.requestMatchers("/**").authenticated());
        http.httpBasic(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }

//        http.authorizeHttpRequests(api -> api.requestMatchers("/**").authenticated();
//        http.authorizeHttpRequests(api -> api.requestMatchers("/**").permitAll());
//        http.authorizeHttpRequests(api -> api.requestMatchers("/api/teachers").hasRole("ADMIN"));
//        http.authorizeHttpRequests(api -> api.requestMatchers("/api/teachers").hasRole("ADMIN"));
//        http.authorizeHttpRequests(api -> api.requestMatchers("/api/teachers").hasAnyRole("ADMIN", "MANGER"));
//        http.authorizeHttpRequests(api -> api.requestMatchers(HttpMethod.GET, "/api/teachers").hasAllRoles("MANGER","ADMIN"));

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails1 = User.withUsername("eslam").password("{bcrypt}$2a$12$IYvUm7SfBHmGfqDGNZPmKOOwDqYUOcJQDE0SQRd71eVDgVBlwEmS6").roles("ADMIN").build();
//        UserDetails userDetails2 = User.withUsername("ahmed").password("{bcrypt}$2a$12$MUHCYCAbsGNrpe5ppri.A.er9X5Htu2065l5KL3ksYAIA2RC6KolW").roles("USER").build();
//        UserDetails userDetails3 = User.withUsername("ali").password("{bcrypt}$2a$12$JL8hfSP86UUkxj758JTYUeFH3Ze/IuNw2WQeBY3.rA6SULGK2EqXm").roles("MANGER", "ADMIN").build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//    }
}
/// $2a$12$JL8hfSP86UUkxj758JTYUeFH3Ze/IuNw2WQeBY3.rA6SULGK2EqXm    789
//  789 $2a$12$JL8hfSP86UUkxj758JTYUeFH3Ze/IuNw2WQeBY3.rA6SULGK2EqXm
