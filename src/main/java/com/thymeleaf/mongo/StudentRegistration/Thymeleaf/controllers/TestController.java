package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    // ADD STUDENT ROUTE
    @GetMapping("/hahaha")
    public String addStudentRoute(Model m) {
        m.addAttribute("student", new Students());
        return "addStudent";
    }
}
