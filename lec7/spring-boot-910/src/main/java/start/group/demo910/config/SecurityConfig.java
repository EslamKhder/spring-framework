package start.group.demo910.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers(HttpMethod.GET, "/players").hasRole("ADMIN")
                        .anyRequest().authenticated());

        http.httpBasic(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails1 =
                User.withUsername("eslam").password("{noop}eslam123").roles("ADMIN", "USER").build();
        UserDetails userDetails2 =
                User.withUsername("ahmed").password("{noop}ahmed456").roles("MANAGER", "USER").build();
        UserDetails userDetails3 =
                User.withUsername("mona").password("{noop}mona789").roles("USER").build();

        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
    }

}
