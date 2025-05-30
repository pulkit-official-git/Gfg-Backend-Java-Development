package com.example.minor_project_1.repositories;

import com.example.minor_project_1.dtos.GetStudentDetailResponse;
import com.example.minor_project_1.dtos.StudentStatus;
import com.example.minor_project_1.models.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    @Modifying
    @Query("update Student s set s.status = ?2 where s.id = ?1")
    void deactivate(Integer id, StudentStatus status);
}
