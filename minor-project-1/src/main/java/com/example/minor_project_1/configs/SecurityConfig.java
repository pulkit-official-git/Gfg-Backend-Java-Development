package com.example.minor_project_1.configs;

import com.example.minor_project_1.models.Authority;
import com.example.minor_project_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(
            UserService userService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/students/admin/**").hasAuthority(Authority.ADMIN.name())
                        .requestMatchers("/students/**").hasAuthority(Authority.STUDENT.name())
                        .requestMatchers("/admin/**").hasAuthority(Authority.ADMIN.name())
                        .requestMatchers("/book/add/**").hasAuthority(Authority.ADMIN.name())
                        .requestMatchers("/book/**").hasAnyAuthority(Authority.ADMIN.name(),Authority.STUDENT.name())
                        .requestMatchers("/transactions/**").hasAuthority(Authority.STUDENT.name())
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
