package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "students")
public class Students {
    @Id
    private int id;
    private String name;
    private String brith_of_date;
    private int class_id;
}
