package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    private int id;
    private String name;
    private String brith_of_date;
    private int class_id;
}
