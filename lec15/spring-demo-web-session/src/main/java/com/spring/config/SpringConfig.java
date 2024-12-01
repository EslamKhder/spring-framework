package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    @Autowired
    private AuthFilter authFilter;

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        userDetailsManager.setUsersByUsernameQuery(
//                "select US_NA, PSW, EN_ABLE from USERS_SYSTEM where US_NA = ?"
//        );
//
//        userDetailsManager.setAuthoritiesByUsernameQuery(
//                "select US_NA, ROLE from ROLES where US_NA = ?"
//        );
//
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(
                api -> api
                        .requestMatchers( "/user/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/student/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/teacher/allTeacher").hasAnyRole("EMPLOYEE","MANGER")
        );

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.builder() // TEACHER
                .username("ahmed")
                .password("{noop}ahmed123")
                .roles("USER", "EMPLOYEE")
                .build();

        UserDetails user2 = User.builder()
                .username("karim") // STUDENT
                .password("{noop}karim123")
                .roles("USER")
                .build();

        UserDetails user3 = User.builder()
                .username("jo") // Manger
                .password("{noop}jo123")
                .roles("USER", "EMPLOYEE", "MANGER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }*/
}
