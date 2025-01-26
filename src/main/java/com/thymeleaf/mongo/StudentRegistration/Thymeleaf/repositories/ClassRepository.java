package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.repositories;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Class;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends MongoRepository<Class, String> {
}
