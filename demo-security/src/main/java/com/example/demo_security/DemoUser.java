package com.example.demo_security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoUser implements UserDetails {

    public static final String DELIMITER = "::";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String authorities;

    public Collection<GrantedAuthority> getAuthorities() {
        String [] authorities = this.authorities.split(DELIMITER);
        return Arrays.stream(authorities)
                .map(x->new SimpleGrantedAuthority(x))
                .collect(Collectors.toList());
    }

}
