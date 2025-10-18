package com.spring.boot.config;

import com.spring.boot.config.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
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

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private @Lazy AuthFilter authFilter;

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource source) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(source);
//        return userDetailsManager;
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(api -> api
                .requestMatchers("/login").permitAll()
                .requestMatchers("/signup").permitAll()
                .anyRequest().authenticated());
        httpSecurity.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.csrf(csrf -> csrf.disable());

        httpSecurity.httpBasic(AbstractHttpConfigurer::disable);
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);

        httpSecurity.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("eslam").password("{bcrypt}$2a$12$fxkCznbMwmZHUtMhmi0Iyuu1ZowUCd8zPZi12mapLhQkpsFfgn7l.")
//                .disabled(true)
//                .accountExpired(true)
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withUsername("ahmed").password("{bcrypt}$2a$12$tGBFA1.YVOsz4qBZvCOoDOCfBUu9umQlf010wW/kVWGz67gzw1yBi")
//                .roles("USER", "ADMIN").build();
//        UserDetails user3 = User.withUsername("moahmed").password("{bcrypt}$2a$12$zpQSbMkMTKDlD9pAFjWs3uV20tf0T52PKTM0IWt6kQ2h2ZYCSPkJ2")
//                .roles("USER", "ADMIN", "MANGER").build();
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
