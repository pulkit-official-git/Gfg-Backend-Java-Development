package com.example.minor_project_1.service;

import com.example.minor_project_1.dtos.GetStudentDetailResponse;
import com.example.minor_project_1.dtos.StudentCreateRequest;
import com.example.minor_project_1.dtos.StudentStatus;
import com.example.minor_project_1.dtos.UpdateStudentRequest;
import com.example.minor_project_1.models.Authority;
import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.models.Student;
import com.example.minor_project_1.models.User;
import com.example.minor_project_1.repositories.BookRepository;
import com.example.minor_project_1.repositories.StudentCacheRepository;
import com.example.minor_project_1.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    StudentCacheRepository studentCacheRepository;


    ObjectMapper mapper = new ObjectMapper();


    public GetStudentDetailResponse getStudent(Integer id) {

        Student student = this.studentCacheRepository.get(id);
        if (student != null) {
            GetStudentDetailResponse getStudentDetailResponse = GetStudentDetailResponse.builder()
                    .student(student)
                    .bookList(student.getBookList())
                    .build();

            return getStudentDetailResponse;
        }

        student = this.studentRepository.findById(id).orElse(null);
        List<Book> bookList = this.bookService.findByStudentId(id);
        this.studentCacheRepository.add(student);

        GetStudentDetailResponse getStudentDetailResponse = GetStudentDetailResponse.builder()
                .student(student)
                .bookList(bookList)
                .build();

        return getStudentDetailResponse;
    }

    public Integer add(StudentCreateRequest studentCreateRequest) {
        Student student = studentCreateRequest.toStudent();

        User user = this.userService.createUser(student.getUser(), Authority.STUDENT);
        student.setUser(user);
        this.studentRepository.save(student);
        return student.getId();
//        Student student = studentCreateRequest.toStudent();
////        return this.studentRepository.save(student).getId(); // way 1 spring3
//        student = this.studentRepository.save(student);// way 2  spring 3  spring 2
//        return student.getId();
    }

    public GetStudentDetailResponse updateStudent(Integer id, UpdateStudentRequest updateStudentRequest) {
        Student incomingStudent = updateStudentRequest.toStudent();
        Student savedStudent = this.studentRepository.findById(id).orElse(null);
        Student target = merge(incomingStudent, savedStudent);
        target = this.studentRepository.save(target);
        GetStudentDetailResponse getStudentDetailResponse = GetStudentDetailResponse.builder()
                .student(target)
                .build();
        return getStudentDetailResponse;

    }

    private Student merge(Student incoming, Student saved) {
        JSONObject incomingStudent = mapper.convertValue(incoming, JSONObject.class);
        JSONObject savedStudent = mapper.convertValue(saved, JSONObject.class);

        Iterator it = incomingStudent.keySet().iterator();  // id, name, email, mobile .....
        while (it.hasNext()) {
            String key = (String)it.next();
            if(incomingStudent.get(key) != null) {
                savedStudent.put(key, incomingStudent.get(key));
            }
        }

        return mapper.convertValue(savedStudent, Student.class);
    }

    public GetStudentDetailResponse deactivate(Integer id) {
         this.studentRepository.deactivate(id, StudentStatus.INACTIVE);
         return this.getStudent(id);
//         return
    }


//    public StudentCreateResponse getStudent(Integer id) {
//
//        Student student = this.studentRepository.findById(id).orElse(null);
//        List<Book> bookList = this.bookRepository.findByStudentId(id);
//
//        StudentCreateResponse studentCreateResponse = StudentCreateResponse.builder()
//                .student(student)
//                .bookList(bookList)
//                .build();
//
//        return studentCreateResponse;
//    }
}
