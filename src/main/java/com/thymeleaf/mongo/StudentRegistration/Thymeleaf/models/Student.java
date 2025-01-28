package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String brith_of_date;
    private List<Class> classes;
    @Field("locale")  // Ensure this field is mapped correctly
    private String locale;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrith_of_date() {
        return brith_of_date;
    }

    public List<Class> getClasses() {
        return classes;
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

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brith_of_date='" + brith_of_date + '\'' +
                ", classes=" + classes.toString() +
                '}';
    }
}
