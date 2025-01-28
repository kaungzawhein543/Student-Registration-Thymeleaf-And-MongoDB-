package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection ="classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {

    @Id
    private String id;
    private String name;
    private String startTime;
    private String endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return (name != null ? name : "Unnamed Class") +
                " (Start: " + (startTime != null ? startTime : "N/A") +
                ", End: " + (endTime != null ? endTime : "N/A") + ")";
    }
}
