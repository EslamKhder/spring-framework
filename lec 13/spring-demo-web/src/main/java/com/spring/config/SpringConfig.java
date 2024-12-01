package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {
/*
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

        http.authorizeHttpRequests(
                api -> api
                        .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v2/api-docs/**", "/swagger-resources/**", "/webjars/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "/student/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/teacher/allTeacher").hasAnyRole("EMPLOYEE","MANGER")
        );

        http.httpBasic(Customizer.withDefaults());

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
