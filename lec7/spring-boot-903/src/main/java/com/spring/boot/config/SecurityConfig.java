package com.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST, "/account/**").hasAnyRole("ADMIN");
//        http.csrf().disable();

        http.csrf(httpCsrf -> httpCsrf.disable());
        http.authorizeHttpRequests(api ->
                api.requestMatchers(HttpMethod.GET, "/account/allAccount").hasAnyRole("ADMIN", "USER")
                   .requestMatchers(HttpMethod.POST, "/account/addAccount").hasAnyRole("ADMIN")
        );


        //.requestMatchers(HttpMethod.GET, "/account/search/phone").hasAnyRole("ADMIN", "USER");


        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
    // level only user
    // in memory
    // database
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        // {noop}ahmed123
        // {bcrypt}$2a$12$9fgj5ZjK1DjrNRApCmkYMu7ydLuTyPrMiDPTFhd3K0xNvWovvHsfC
        UserDetails userDetails1 = User.withUsername("ahmed").password("{noop}ahmed123").roles("USER", "ADMIN").build();
        UserDetails userDetails2 = User.withUsername("eslam").password("{noop}eslam123").roles("USER").build();
        UserDetails userDetails3 = User.withUsername("mona").password("{noop}mona123").roles("MANGER").build();

        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
    }*/
}
