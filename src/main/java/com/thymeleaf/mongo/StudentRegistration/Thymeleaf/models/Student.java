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
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(id != null ? id : "N/A").append("\n");
        sb.append("Name: ").append(name != null ? name : "N/A").append("\n");
        sb.append("Birth Date: ").append(brith_of_date != null ? brith_of_date : "N/A").append("\n");
        sb.append("Classes: ");
        if (classes != null && !classes.isEmpty()) {
            sb.append("\n");
            for (Class clazz : classes) {
                sb.append("  - ").append(clazz).append("\n");
            }
        } else {
            sb.append("No classes available\n");
        }
        return sb.toString();
    }
}
