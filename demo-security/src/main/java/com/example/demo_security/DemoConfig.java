package com.example.demo_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    @Autowired
    PasswordEncoderConfig passwordEncoderConfig;

    @Bean
    public AuthenticationManager authenticationManager(
            DemoUserDetailsService demoUserDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(demoUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }


//    @Bean
//    public InMemoryUserDetailsManager cpnfigureAuthentication() {
//
//        UserDetails user1 = User.builder()
//                .username("admin")
//                .password("$2a$12$D.8.OH0rsILUU4PzObHd1e/SLR12xFURorzwFZ4QDxKBbO0EuP.ba")
//                .authorities("ADMIN")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("user")
//                .password("$2a$12$UMBy9vmAqBgXRmnVWrY65.trrrdAwObUy1X/2gb1o2Ymkv6ULelcS")
//                .authorities("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/signup").permitAll()
                        .requestMatchers("/user/**").hasAuthority("USER")
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
