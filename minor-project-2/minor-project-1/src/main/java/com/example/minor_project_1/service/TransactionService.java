package com.example.minor_project_1.service;

import com.example.minor_project_1.models.*;
import com.example.minor_project_1.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Value("${student.books.max-allowed}")
    Integer maxAllowedBooks;

    @Value("${student.return-duration}")
    Integer returnDuration;

    @Value("${student.return-fine}")
    Integer returnFine;



    public String initiateTxn(Integer studentId, Integer bookId, TransactionType transactionType) throws Exception {
        switch (transactionType) {
            case ISSUE:
                return inititateIssue(studentId,bookId);
            case RETURN:
                return  initiateReturn(studentId,bookId);
            default:
                throw new Exception("Invalid Txn Type");
        }
    }

    // Validations
    // 1. valid book/ student or not
    // 2. book is available or not
    // 3. limit student on no. of books
    //-----------------------
    //4. transaction table, i can make status as pending
    //5. update transaction tabvle status as Success
    //6. we have handle wrong transaction and make status as Failed

    private String inititateIssue(Integer studentId, Integer bookId) throws Exception {

        // ---------------Data Retrieval-----------------
        Student student = this.studentService.getStudent(studentId).getStudent();
        Book book = this.bookService.getBooks(bookId);

        // ----------------Validations-----------------

        if(student==null){
            throw new Exception("Student is not present");
        }

        if(book==null || book.getStudent()!=null){
            throw new Exception("Book is not available for issue");
        }

        List<Book> issuedBooks = student.getBookList();

        if(issuedBooks!=null && issuedBooks.size()>this.maxAllowedBooks){
            throw new Exception("Student has availed maximum no. of books");
        }

        //------------------Issuance of book ----------------

        Transaction transaction = Transaction.builder()
                .student(student)
                .book(book)
                .externalId(UUID.randomUUID().toString())
                .transactionType(TransactionType.ISSUE)
                .status(TransactionStatus.PENDING)
                .build();

        transaction = transactionRepository.save(transaction);

        try {
            book.setStudent(student); // join with student
            this.bookService.addBook(book);
            transaction.setStatus(TransactionStatus.SUCCESS);
            this.transactionRepository.save(transaction);

        }catch (Exception e){
            transaction.setStatus(TransactionStatus.FAILED);
            this.transactionRepository.save(transaction);
            if(book.getStudent()!=null){   //rollback
                book.setStudent(null);    // removing join/association
                this.bookService.addBook(book);
            }
        }

        return transaction.getExternalId();
    }


    // Validations
    // 1. valid book/ student or not
    // 2. book is assigned or not

    //-----------------------
    //3. transaction table, i can make status as pending
    //4. Make the book available for other users
    //5. update transaction tabvle status as Success
    //6. we have handle wrong transaction and make status as Failed

    public String initiateReturn(Integer studentId, Integer bookId) throws Exception {
        // ---------------Data Retrieval-----------------
        Student student = this.studentService.getStudent(studentId).getStudent();
        Book book = this.bookService.getBooks(bookId);

        // ----------------Validations-----------------

        if(student==null){
            throw new Exception("Student is not present");
        }
// book.getStudent()==null not assigned to anyone
// book.getStudent().getId()!=studentId not assinged to particular student
        if(book==null || book.getStudent()==null || book.getStudent().getId()!=studentId){
            throw new Exception("Book is not available for issue");
        }

        Integer fine = this.calculateFine(book,student);

        Transaction transaction = Transaction.builder()
                .student(student)
                .book(book)
                .externalId(UUID.randomUUID().toString())
                .transactionType(TransactionType.RETURN)
                .status(TransactionStatus.PENDING)
                .fine(fine)
                .build();

        transaction = transactionRepository.save(transaction);

        try {
            book.setStudent(null); // make the book available
            this.bookService.addBook(book);
            transaction.setStatus(TransactionStatus.SUCCESS);
            this.transactionRepository.save(transaction);

        }catch (Exception e){
            transaction.setStatus(TransactionStatus.FAILED);
            this.transactionRepository.save(transaction);
            if(book.getStudent()==null){   //rollback
                book.setStudent(student);
                this.bookService.addBook(book);
            }
        }

        return transaction.getExternalId();


    }

    public Integer calculateFine(Book book, Student student) {
        Transaction txn = this.transactionRepository.findTopByStudentAndBookAndTransactionTypeAndStatusOrderByIdDesc(student,book,TransactionType.ISSUE,TransactionStatus.SUCCESS);
        Long issuedTimeInMillis = txn.getUpdatedOn().getTime();
        Long timeDiff = System.currentTimeMillis() - issuedTimeInMillis;

        Long daysPassed = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        if(daysPassed>returnDuration){
            return (daysPassed.intValue()-returnDuration)*returnFine;
        }
        return 0;
    }
}

