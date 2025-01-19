package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.repositories;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Students, Integer> {

}
