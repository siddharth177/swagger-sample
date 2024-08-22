package com.example.swaggersample.services;

import com.example.swaggersample.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public static List<Student> students = new ArrayList<>(){{
        add(new Student(1, "Ashok"));
        add(new Student(2, "Bob"));
        add(new Student(3, "Jack"));
        add(new Student(4, "Mary"));
        add(new Student(5, "Tom"));
    }};
}
