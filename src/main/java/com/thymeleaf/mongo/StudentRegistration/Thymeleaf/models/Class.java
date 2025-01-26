package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection ="classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
