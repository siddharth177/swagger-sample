package com.example.swaggersample.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Schema(name = "Student", description = "Scheme of Student Object")
public class Student {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @Schema(allowableValues = {"Physics", "Chemistry", "Maths", "English"})
    private List<String> courses = new ArrayList<>();
    private String email = "";

    public Student(int i, String name) {
        this.id = i;
        this.name = name;
    }
}
