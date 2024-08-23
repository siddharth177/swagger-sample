package com.example.swaggersample.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.swaggersample.services.StudentService.students;

@Data
@Schema(    // used on a POJO
        title = "Student Schema",
        name = "Student",
        description = "Scheme of Student Object",
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
}
