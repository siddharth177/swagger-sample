package com.example.swaggersample.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Schema(    // used on a POJO
        title = "Student Schema",
        name = "Student",
        description = "Schema of Student Object",
        deprecated = false
)
public class Student {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @Schema(allowableValues = {"Physics", "Chemistry", "Maths", "English"})
    private List<String> courses = new ArrayList<>();
    private String email = "";

    public Student(int i, @NonNull String name) {
        this.id = i;
        this.name = name;
    }

    public Student(int i, @NonNull String name, List<String> courses, String email) {
        this.id = i;
        this.name = name;
        this.courses = courses;
        this.email = email;
    }
}
