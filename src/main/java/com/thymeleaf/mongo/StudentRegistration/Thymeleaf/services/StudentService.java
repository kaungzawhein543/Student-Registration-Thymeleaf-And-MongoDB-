package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.services;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Slf4j
@Service
public class StudentService {

    // STUDENT REPOSITORY
    private final StudentRepository studentRepository;
    private final MongoTemplate atlasMongoTemplate;

    // GET LOGGER
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository,
                          @Qualifier("atlasMongoTemplate") MongoTemplate atlasMongoTemplate) {
        this.studentRepository = studentRepository;
        this.atlasMongoTemplate = atlasMongoTemplate;
    }

    // ADD STUDENT
    public Students addStudent(Students student) {
//        Students resultStudentAtlas = atlasMongoTemplate.save(student, "students");
        studentRepository.save(student);
        return  new Students();
    }

    // GET ALL STUDENTS
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET STUDENTS BY NAME
    public List<Students> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    // UPDATE STUDENT WITH ID
    public Students updateStudent(Students student) {
        Optional<Students> studentFromDb =  studentRepository.findById(student.getId());

        if(studentFromDb.isPresent()) {
             return studentRepository.save(student);
        }else {
            logger.error("STUDENT NOT FOUND ERROR IN SERVICE CLASS IN UPDATE METHOD");
            throw new RuntimeException("Student Not Found");
        }
    }

    // DELETE STUDENT WITH ID
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
