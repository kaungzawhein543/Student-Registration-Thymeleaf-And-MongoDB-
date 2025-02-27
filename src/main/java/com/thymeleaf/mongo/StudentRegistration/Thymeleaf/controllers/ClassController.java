package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.controllers;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Class;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.ClassService;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String save(@ModelAttribute Class classObj, RedirectAttributes redirectAttributes) {
          Class resultClass = classService.save(classObj);
          if(resultClass != null) {
              redirectAttributes.addFlashAttribute("message","Add Class Successfully");
          } else {
              redirectAttributes.addFlashAttribute("errorMessage","Add Class Failed");
          }
        return "redirect:/classes/addClass";
    }

    // ADD CLASS FILE ROUTE
    @GetMapping("addClass")
    public String save(Model m) {
        m.addAttribute("class", new Class());
        if(m.containsAttribute("message")) {
            m.addAttribute("message", m.getAttribute("message"));
        }else if(m.containsAttribute("errorMessage")) {
            m.addAttribute("errorMessage", m.getAttribute("errorMessage"));
        }
        return "addClass";
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
