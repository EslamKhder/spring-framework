package com.spring.boot.config;

import com.spring.boot.config.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

    public static final String [] PUBLIC_APIS = {
            "/auth/**",
            "/swagger-ui/**",
            "/v3/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        httpSecurity.authorizeHttpRequests(
                api -> api.requestMatchers(PUBLIC_APIS).permitAll()
                        .anyRequest().authenticated()
        );

        httpSecurity.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("ahmed")
//                .disabled(true)
//                .password("{bcrypt}$2a$12$ClGL4/kKKMuJCW0ocRJkuOuqcGHgHn03aUPASgISpd6NtK7W3.gtq")
//                .roles("USER","ADMIN").build();
//        UserDetails user2 = User.withUsername("eslam")
//                .password("{bcrypt}$2a$12$j3Hl8CFhjYwcSxqTcGdN.O.bwxdeNNBp0jNTA1R1ZKT3GKWYy4yXa")
//                .roles("USER").build();
//        UserDetails user3 = User.withUsername("mona")
//                .password("{bcrypt}$2a$12$/TsaMRUtqFQ7lg7vMSwoZOcpcLvW/ZaxKr89O7NeCQSGgWG0cd2eC")
//                .roles("USER", "MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
