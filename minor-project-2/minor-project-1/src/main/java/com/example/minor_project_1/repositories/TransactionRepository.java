package com.example.minor_project_1.repositories;

import com.example.minor_project_1.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTopByStudentAndBookAndTransactionTypeAndStatusOrderByIdDesc(Student student, Book book, TransactionType transactionType, TransactionStatus transactionStatus);
}
