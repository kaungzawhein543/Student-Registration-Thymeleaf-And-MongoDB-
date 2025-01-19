package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;


import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@SuppressWarnings("unused")
@RequestMapping("api/v2/students")
public class StudentController {


    // STUDENT SERVICE
    private final StudentService studentService;

    // GET LOGGER
    private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // HOME PAGE
    public String homePage() {
        return "index";
    }

    // ADD STUDENT
    @PostMapping
    public Students addStudent(@RequestBody Students student) {
        logger.info(student.toString());
        return  studentService.addStudent(student);
    }

    // GET ALL STUDENTS
    @GetMapping("/all")
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

    // UPDATE STUDENT WITH ID
    @PostMapping("/update")
    public Students updateStudent(@RequestBody Students student) {
        return studentService.updateStudent(student);
    }

    // DELETE STUDENT WITH ID
    @DeleteMapping
    public void deleteStudent(@RequestParam("id") String id) {
        studentService.deleteStudent(id);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
