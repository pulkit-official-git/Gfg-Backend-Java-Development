package com.example.minor_project_1.repositories;

import com.example.minor_project_1.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
