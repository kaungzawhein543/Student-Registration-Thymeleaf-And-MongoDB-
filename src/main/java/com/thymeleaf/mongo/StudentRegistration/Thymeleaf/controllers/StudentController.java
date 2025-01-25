package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;


import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
@SuppressWarnings("unused")
@RequestMapping("/students")
public class StudentController {


    // STUDENT SERVICE
    private final StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String homePage() {
        return "index";
    }

    // ADD STUDENT ROUTE
    @GetMapping("/addStudent")
    public String addStudentRoute(Model m) {
        m.addAttribute("student", new Students());
        return "addStudent";
    }


    // ADD STUDENT DATA
    @PostMapping("/add")
    public String addStudentForm(@ModelAttribute Students student, RedirectAttributes redirectAttributes) {
        studentService.addStudent(student);
        redirectAttributes.addFlashAttribute("message", "Add Student Successfully.");
        return  "redirect:/students/addStudent";
    }

    @RequestMapping(value = "/findStudents", method = RequestMethod.GET)
    public String goFindStudentRoute(Model model) {
        // Flash attributes automatically populate the model on redirect
        if (model.containsAttribute("students")) {
            model.addAttribute("students", model.getAttribute("students"));
        }
        return "findStudent";
    }

    // GET ALL STUDENTS
    @PostMapping("/all")
    public String getAllStudents(@RequestParam String name, RedirectAttributes redirectAttributes) {
        if (name == null || name.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Input Can't Be Null Or Empty");
            return "redirect:/students/findStudents";
        }
        List<Students> students = studentService.getStudentsByName(name);
        redirectAttributes.addFlashAttribute("students", students);
        return "redirect:/students/findStudents";
    }




    // UPDATE STUDENT WITH ID
    @PostMapping("/update")
    public Students updateStudent(@RequestBody Students student) {
        return studentService.updateStudent(student);
    }

    // DELETE STUDENT WITH ID
    @GetMapping("deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/error")
    public String testError() {
        throw new RuntimeException("Error Testing");
    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleException(Exception e, HttpServletRequest request) {
//        Map<String, Object> errorDetails = new HashMap<>();
//        errorDetails.put("timestamp", LocalDateTime.now());
//        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
//        errorDetails.put("error","INTERNAL SERVER ERROR");
//        errorDetails.put("message", e.getMessage());
//        errorDetails.put("path", request.getRequestURI());
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @GetMapping("/test")

    public String test() {

        return "index"; // Ensure you have an index.html in your templates

    }
}
