package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/headers")
    public ResponseEntity<String> getHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return ResponseEntity.ok("Check console for headers!");
    }
}
