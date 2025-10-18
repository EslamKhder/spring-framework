package com.spring.boot908.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

        http.sessionManagement(session ->  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //http://localhost:9090/teacher/username/{{username}}
        http.authorizeHttpRequests(requests -> requests
                .anyRequest().authenticated());

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http.formLogin(AbstractHttpConfigurer::disable);

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails userDetails1 = User.withUsername("ahmed").password("{bcrypt}$2a$12$67bBo6YdvJDu0.hxbXygCuMtnaZkwGzfCH2uzphv1SracrOyJ05OO")
//                .roles("USER").build();
//
//        UserDetails userDetails2 = User.withUsername("eslam").password("{bcrypt}$2a$12$.KjWRqy15LAZwey3F3xI/.1HaibonHmsGfcdkYqMCjwA0y0mTjXza")
//                .roles("ADMIN").build();
//
//        UserDetails userDetails3 = User.withUsername("mona").password("{bcrypt}$2a$12$O88wVtgYJLJkQcHGn8YCreL2Dl7YtXbef7fuBVp0WSxIY0pmq1Tb2")
//                .roles("ADMIN", "USER").build();
//
//        return new InMemoryUserDetailsManager(userDetails1,userDetails2, userDetails3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
