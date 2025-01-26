package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Class;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.ClassService;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classes/")
public class ClassController {

    // CREATE STUDENT SERVICE
    private final ClassService classService;

    // CONSTRUCTOR
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    // ADD CLASS
    @PostMapping("add")
    public Class save(@ModelAttribute Class classObj) {
        return  classService.save(classObj);
    }

    // GET ALL CLASS
    @GetMapping("findAll")
    public List<Class> findAll() {
        return classService.findAll();
    }

    // DELETE CLASS WITH ID
    @GetMapping("deleteById")
    public void deleteById(String id) {
        classService.deleteById(id);
    }
}
