package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.repositories;

import com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Students, String> {

    @Query("{ 'name' : ?0 }")
    List<Students> findByName(String name);
}
