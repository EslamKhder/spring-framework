package com.spring.demo911.config.security;

import com.spring.demo911.config.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthFilter authFilter;
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource source){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(source);
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(csrfToke -> csrfToke.disable());
//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated());

        http.httpBasic(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
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
