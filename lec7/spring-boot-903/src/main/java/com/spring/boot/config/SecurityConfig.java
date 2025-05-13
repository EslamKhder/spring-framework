package com.spring.boot.config;

import com.spring.boot.config.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthFilter authFilter;

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // prevent store on session
        http.sessionManagement(httpSessionManagement -> httpSessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.csrf(httpCsrf -> httpCsrf.disable());

        http.authorizeHttpRequests(api ->
                api.anyRequest().authenticated()
        );

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//        http.httpBasic(Customizer.withDefaults());

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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
