package com.example.minor_project_1.repositories;

import com.example.minor_project_1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
