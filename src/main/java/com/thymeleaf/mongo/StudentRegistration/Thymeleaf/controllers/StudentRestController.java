package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/students/")
public class StudentRestController {

    // STUDENT SERVICE
    private final StudentService studentService;

    // GET LOGGER
    private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
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
}
