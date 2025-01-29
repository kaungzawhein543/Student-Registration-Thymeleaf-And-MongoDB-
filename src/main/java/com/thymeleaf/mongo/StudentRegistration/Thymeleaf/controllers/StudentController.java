package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;


import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Class;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Student;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.ClassService;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;


@Controller
@SuppressWarnings("unused")
@RequestMapping("/students")
public class StudentController {


    //  SERVICES
    private final StudentService studentService;
    private final ClassService classService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService, ClassService classService) {
        this.studentService = studentService;
        this.classService = classService;
    }

    @GetMapping
    public String homePage() {
        return "index";
    }

    // ADD STUDENT ROUTE
    @GetMapping("/addStudent")
    public String addStudentRoute(Model m) {
        m.addAttribute("student", new Student());
        List<Class> classes = classService.findAll();
        if (!classes.isEmpty()) {
            m.addAttribute("classes",classes);
        }
        return "addStudent";
    }


    // ADD STUDENT DATA
    @PostMapping("/add")
    public String addStudentForm(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
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

    // GET ALL STUDENTS BY NAME
    @PostMapping("/findByName")
    public String getAllStudentsByName(@RequestParam String name, RedirectAttributes redirectAttributes, Model m) {
        if (name == null || name.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Input Can't Be Null Or Empty");
            return "redirect:/students/findStudents";
        }
        List<Student> students = studentService.getStudentsByName(name);
        redirectAttributes.addFlashAttribute("students", students);
        return "redirect:/students/findStudents";
    }

    @GetMapping("/findAll")
    public String getAllStudents(RedirectAttributes redirectAttributes, Model m) {
        List<Student> students = studentService.getAllStudents();
        redirectAttributes.addFlashAttribute("students", students);
        return "redirect:/students/findStudents";
    }


    // UPDATE STUDENT WITH ID
    @GetMapping("/updateStudent/{id}")
    public String updateStudentPage(@PathVariable("id") String id,Model m) {
        Optional<Student> studentForUpdate = studentService.getStudentsByID(id);
        List<Class> classes = classService.findAll();
        if (!classes.isEmpty()) {
            m.addAttribute("classes",classes);
        }
        if (studentForUpdate.isPresent()) {
            m.addAttribute("student",studentForUpdate.get());
        } else if(m.containsAttribute("student")) {
            m.addAttribute("student", m.getAttribute("student"));
        }
        return "updateStudent";
    }

    // DELETE STUDENT WITH ID
    @PostMapping("updateStudent")
    public String updateStudent(@ModelAttribute Student student,RedirectAttributes redirectAttributes) {
        System.out.println(student);
        Student resultStudent = studentService.updateStudent(student);
        if (resultStudent != null) {
            redirectAttributes.addFlashAttribute("message", "Update Student Successfully");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Update Student Failed");
        }
        redirectAttributes.addFlashAttribute("student",resultStudent);
        List<Class> classes = classService.findAll();
        if (!classes.isEmpty()) {
            redirectAttributes.addFlashAttribute("classes",classes);
        }
        return "redirect:/students/updateStudent/"+student.getId();
    }


    // DELETE STUDENT WITH ID
    @GetMapping("deleteStudent/{studentId}/{studentName}")
    public String deleteStudent(@PathVariable("studentId") String studentId,@PathVariable("studentName") String studentName,RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(studentId);
        System.out.println(studentId);
        List<Student> students = studentService.getStudentsByName(studentName);
        redirectAttributes.addFlashAttribute("students", students);
        return "redirect:/students/findStudents";
    }

    @GetMapping("/error")
    public String testError() {
        throw new RuntimeException("Error Testing");
    }


        /*        @ExceptionHandler(Exception.class)
        public ResponseEntity<Map<String, Object>> handleException(Exception e, HttpServletRequest request) {
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            errorDetails.put("error","INTERNAL SERVER ERROR");
            errorDetails.put("message", e.getMessage());
            errorDetails.put("path", request.getRequestURI());
            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }*/

    @GetMapping("/test")

    public String test() {

        return "index"; // Ensure you have an index.html in your templates

    }
}
