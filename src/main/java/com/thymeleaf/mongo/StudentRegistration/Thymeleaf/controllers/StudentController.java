package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;


import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // ADD STUDENT ROUTE
    @GetMapping("add")
    public String addStudentRoute(Model m) {
        m.addAttribute("student", new Students());
        return  "addStudent";
    }

    // ADD STUDENT DATA
    @PostMapping("add")
    public String addStudentForm(@RequestBody Students student, Model m) {
        m.addAttribute("message", "Add Student Successfully.");
        return  "addStudent";
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

    @GetMapping("/error")
    public String testError() {
        throw new RuntimeException("Error Testing");
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        errorDetails.put("error","INTERNAL SERVER ERROR");
        errorDetails.put("message", e.getMessage());
        errorDetails.put("path", request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
