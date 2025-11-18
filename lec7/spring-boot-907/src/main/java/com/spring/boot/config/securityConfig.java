package com.spring.boot.config;

import com.spring.boot.config.exception.CustomAccessDeniedHandler;
import com.spring.boot.config.exception.CustomAuthEntryPoint;
import com.spring.boot.config.filters.AuthFilter;
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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class securityConfig {

    @Autowired
    private AuthFilter authFilter;

    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager userDetailsManager =
//                new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // /teachers
//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated());


//
//                .requestMatchers(HttpMethod.GET, "/teachers").hasAnyRole("ADMIN", "EMPLOYEE")
        http.csrf(csrf -> csrf.disable());
        http.httpBasic(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.exceptionHandling(ex -> ex
                .authenticationEntryPoint(customAuthEntryPoint)     // 401
                .accessDeniedHandler(customAccessDeniedHandler)      // 403
        );
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User.withUsername("ahmed").password("{bcrypt}$2a$12$2otl6V9mCSRgtPFaDpfxy.BQaFRTw46Ub/gPNpP1BZIThpd7KEILC")
//                .roles("ADMIN").build();
//
//        UserDetails user2 = User.withUsername("eslam").password("{bcrypt}$2a$12$/EE16zqInA4HHEv03itLSehbM2QAZsnDe5Gn7eVKwLJohV7swF1gK")
//                .roles("USER", "EMPLOYEE").build();
//
//        UserDetails user3 = User.withUsername("mona").password("{bcrypt}$2a$12$1bQKqs3nbg9s09ht.w011.8Z77/7UgUlcYF.UVIw/VlPSCe8xwEd6")
//                .roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }

}
