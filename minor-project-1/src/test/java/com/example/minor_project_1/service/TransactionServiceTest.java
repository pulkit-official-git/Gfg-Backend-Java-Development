package com.example.minor_project_1.service;

import com.example.minor_project_1.dtos.GetStudentDetailResponse;
import com.example.minor_project_1.models.*;
import com.example.minor_project_1.repositories.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @InjectMocks
    TransactionService transactionService;

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    StudentService studentService;

    @Mock
    BookService bookService;

    @Test
    public void testCalculatFine_WithFine(){
        Book book = Book.builder()
                .id(1)
                .name("HISTORY")
                .build();

        Student student = Student.builder()
                .id(1)
                .name("Ram")
                .build();

        Transaction transaction = Transaction.builder()
                .id(1)
                .book(book)
                .student(student)
                .updatedOn(new Date(1743697842000l))
                .transactionType(TransactionType.ISSUE)
                .status(TransactionStatus.SUCCESS)
                .build();

        Mockito.when(transactionRepository.findTopByStudentAndBookAndTransactionTypeAndStatusOrderByIdDesc(Mockito.eq(student),
                Mockito.eq(book),
                Mockito.eq(TransactionType.ISSUE),
                Mockito.eq(TransactionStatus.SUCCESS))).thenReturn(transaction);

        ReflectionTestUtils.setField(transactionService, "returnDuration", 15);
        ReflectionTestUtils.setField(transactionService, "returnFine", 1);
        int fine = transactionService.calculateFine(book,student);

        Assert.assertEquals(15,fine);


    }

    @Test
    public void testCalculatFine_WithoutFine(){
        Book book = Book.builder()
                .id(1)
                .name("HISTORY")
                .build();

        Student student = Student.builder()
                .id(1)
                .name("Ram")
                .build();

        Transaction transaction = Transaction.builder()
                .id(1)
                .book(book)
                .student(student)
                .updatedOn(new Date(1746290969000l))
                .transactionType(TransactionType.ISSUE)
                .status(TransactionStatus.SUCCESS)
                .build();

        Mockito.when(transactionRepository.findTopByStudentAndBookAndTransactionTypeAndStatusOrderByIdDesc(Mockito.any(),
                Mockito.any(),
                Mockito.any(),
                Mockito.any())).thenReturn(transaction);

        ReflectionTestUtils.setField(transactionService, "returnDuration", 15);
        ReflectionTestUtils.setField(transactionService, "returnFine", 1);
        int fine = transactionService.calculateFine(book,student);

        Assert.assertEquals(0,fine);


    }

    @Test
    public void testInitiateReturn() throws Exception {
        Student student = Student.builder()
                .id(1)
                .name("Ram")
                .build();

        Book book = Book.builder()
                .id(5)
                .student(student)
                .build();


        GetStudentDetailResponse getStudentDetailResponse = GetStudentDetailResponse.builder()
                .student(student)
                .bookList(new ArrayList<>())
                .build();

        String externalId = UUID.randomUUID().toString();

        Transaction transaction = Transaction.builder()
                .id(1)
                .externalId(externalId)
                .book(book)
                .student(student)
                .updatedOn(new Date(1746290969000l))
                .transactionType(TransactionType.ISSUE)
                .status(TransactionStatus.SUCCESS)
                .build();

        Mockito.when(studentService.getStudent(1)).thenReturn(getStudentDetailResponse);
        Mockito.when(bookService.getBooks(1)).thenReturn(book);

        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);

        Mockito.when(transactionRepository.findTopByStudentAndBookAndTransactionTypeAndStatusOrderByIdDesc(Mockito.any(),
                Mockito.any(),
                Mockito.any(),
                Mockito.any())).thenReturn(transaction);

        Mockito.when(bookService.addBook(Mockito.any(Book.class))).thenReturn(book);
        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);



        ReflectionTestUtils.setField(transactionService, "returnDuration", 15);
        ReflectionTestUtils.setField(transactionService, "returnFine", 1);

        String txnId = transactionService.initiateReturn(1,1);
        Assert.assertEquals(externalId,txnId);


    }

}
