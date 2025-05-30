package springdemo.finalprojectrestoran.Config.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class FilterConfig {

    @Autowired
    private AuthFilter authFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.csrf().disable();

        // Disable session creation
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Enable CORS
        http.securityMatcher("/**").cors(cors -> cors.configurationSource(corsConfigurationSource()));

        // Configure endpoint access
        http.authorizeHttpRequests(
                api -> api
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/v3/api-docs*/**").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.POST, "/client/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/client/create-client").permitAll()
                        .requestMatchers(HttpMethod.GET, "/product/getProducts/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/product/getProductsBy/**").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/product/getProductByName/**").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/product/getProductsByletter/**").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/product/getProductSize").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/product/getProductSizeByCategoryId/**").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/product/getProductSizeByKey/**").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/Category/getAll").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/Chefs/getAll").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.POST, "/client/addClientWithRole").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/orders/saveOrder/**").hasRole("USER")
                        .anyRequest().authenticated() // Secure all other endpoints
        );

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
