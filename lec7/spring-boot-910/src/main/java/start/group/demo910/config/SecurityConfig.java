package start.group.demo910.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import start.group.demo910.config.filters.AuthFilter;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    @Autowired
    private AuthFilter authFilter;

    // database
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.sessionManagement(httpManagementConfigurer ->
                httpManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated());

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        http.httpBasic(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());
        http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails1 =
//                User.withUsername("eslam").password("{bcrypt}$2a$12$/S.Bu.uZwpdhTCevK.99OuyTDDwnOdhdgVXYQ52Soya83yOzE/U4q").roles("ADMIN", "MANAGER", "USER").build();
//        UserDetails userDetails2 =
//                User.withUsername("ahmed").password("{bcrypt}$2a$12$/XB2K5waZ84QQhC4dXTf2.L0SLhb7aOg77HAlKRfHmRhvk1/KKLpC").roles("MANAGER", "USER").build();
//        UserDetails userDetails3 =
//                User.withUsername("mona").password("{bcrypt}$2a$12$/qr1dYKODzCxq.wqxCMIX.hCGwnwdCfAgaQqw5QVb3QUtaTlZwWya").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
