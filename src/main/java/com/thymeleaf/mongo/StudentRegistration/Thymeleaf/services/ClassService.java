package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Class;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    // STUDENT REPOSITORY
    private final ClassRepository classRepository;

    // CONSTRUCTOR
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    // ADD CLASS
    public Class save(Class classObj) {
        return  classRepository.save(classObj);
    }

    // GET ALL CLASS
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    // DELETE CLASS WITH ID
    public void deleteById(String id) {
        classRepository.deleteById(id);
    }

}
