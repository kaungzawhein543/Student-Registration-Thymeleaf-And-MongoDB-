package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.repositories;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    @Query(value = "{ 'name' : ?0 }", collation = "en")
    List<Student> findByName(String name);
}
