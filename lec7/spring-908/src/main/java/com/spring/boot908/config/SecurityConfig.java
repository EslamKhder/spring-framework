package com.spring.boot908.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


//    @Bean
//    public UserDetailsService userDetailsManager(DataSource source){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(source);
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                // Any request must be authenticated
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )

                // Enables default login form
                .formLogin(Customizer.withDefaults())

                // Enables HTTP Basic Authentication
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails userDetails1 = User.withUsername("ahmed").password("{bcrypt}$2a$12$GQWXUYfscMLiFb7KCvM7WeqmPDeXxPIA4H29ZY9UuyvIgBAFY9Nji")
//                .roles("ADMIN").build();
//
//        UserDetails userDetails2 = User.withUsername("eslam").password("{noop}eslam456")
//                .roles("USER").build();
//
//        UserDetails userDetails3 = User.withUsername("mona").password("{noop}mona789")
//                .roles("ADMIN", "USER").build();
//
//        return new InMemoryUserDetailsManager(userDetails1,userDetails2, userDetails3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
