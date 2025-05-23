package com.example.demo_security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<DemoUser, Integer> {

    List<DemoUser> findByUsername(String username);
}
