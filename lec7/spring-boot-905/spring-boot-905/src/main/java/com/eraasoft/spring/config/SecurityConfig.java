package com.eraasoft.spring.config;

import com.eraasoft.spring.config.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

// 5
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }

    private AuthFilter authFilter;

    @Autowired
    public SecurityConfig(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http.authorizeHttpRequests(api -> api.requestMatchers("/auth/**").permitAll()
                                             .anyRequest().authenticated());

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//        http.httpBasic(Customizer.withDefaults());
        http.httpBasic(AbstractHttpConfigurer::disable);
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails1 =
//                User.withUsername("ahmed")
//                        .password("{bcrypt}$2a$12$TE4N2lA3NTSdGa4tltnfteFa30q4nc.0HOaymhJ6SAfheStxF/08i")
//                        .roles("USER","ADMIN", "MANGER").build();
//
//        UserDetails userDetails2 =
//                User.withUsername("eslam").password("{bcrypt}$2a$12$vR8P2OMUmw9OHkXmm/oVe.WNJ/Ez8e5d0ezorEsuK53IuR1T1rUqm")
//                        .roles("USER").build();
//
//        UserDetails userDetails3 =
//                User.withUsername("mona").password("{bcrypt}$2a$12$7c5xgC7LBKJxvZp5zkYoFOoyV.qUVdHMqAQAP97jCUFO4JCNBlRYy")
//                        .roles("USER", "ADMIN", "MANGER").build();
//
//        return new InMemoryUserDetailsManager(userDetails1,userDetails2, userDetails3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
