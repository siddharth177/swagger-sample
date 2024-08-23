package com.example.swaggersample.services;

import com.example.swaggersample.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public static List<Student> students = new ArrayList<>(){{
        add(new Student(1, "Ashok", new ArrayList<>(){{add("Physics"); add("Chemistry");}}, "ashok@gmail.com"));
        add(new Student(2, "Bob"));
        add(new Student(3, "Jack"));
        add(new Student(4, "Mary"));
        add(new Student(5, "Tom"));
    }};

    public Object getStudentDetail(int id, String info) {
        Student student = getStudentById(id);
        if (student == null) {
            return "Student with id " + id + " was not found.";
        } else {
            if (info.equalsIgnoreCase("name")) {
                return student.getName();
            } else if (info.equalsIgnoreCase("email")) {
                return student.getEmail();
            } else if (info.equalsIgnoreCase("courses")) {
                return student.getCourses();
            } else {
                return "No such details available";
            }
        }
    }

    public String addStudent(Student student) {
        students.add(student);
        if (getStudentById(student.getId()) != null) {
            return "Student with id " + student.getId() + " is added.";
        } else {
            return "Student with id " + student.getId() + " was not added.";
        }
    }

    public Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }
}
