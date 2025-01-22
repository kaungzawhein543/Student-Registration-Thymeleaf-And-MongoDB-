package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "students")
public class Students {
    @Id
    private String id;
    private String name;
    private String brith_of_date;
    private int class_id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrith_of_date() {
        return brith_of_date;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrith_of_date(String brith_of_date) {
        this.brith_of_date = brith_of_date;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brith_of_date='" + brith_of_date + '\'' +
                ", class_id=" + class_id +
                '}';
    }
}
