package com.example.minor_project_1.repositories;

import com.example.minor_project_1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
