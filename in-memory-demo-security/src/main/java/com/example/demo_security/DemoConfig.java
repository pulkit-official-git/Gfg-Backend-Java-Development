package com.example.demo_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfig {

    @Bean
    public InMemoryUserDetailsManager cpnfigureAuthentication() {

        UserDetails user1 = User.builder()
                .username("admin")
                .password("$2a$12$D.8.OH0rsILUU4PzObHd1e/SLR12xFURorzwFZ4QDxKBbO0EuP.ba")
                .authorities("ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("user")
                .password("$2a$12$UMBy9vmAqBgXRmnVWrY65.trrrdAwObUy1X/2gb1o2Ymkv6ULelcS")
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasAuthority("USER")
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
