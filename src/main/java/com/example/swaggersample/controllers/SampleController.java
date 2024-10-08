package com.example.swaggersample.controllers;

import com.example.swaggersample.models.Student;
import com.example.swaggersample.services.StudentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@OpenAPIDefinition( // defined in a controller class but only once
        info = @Info(
                title = "Swagger Sample Application",   //title on the swagger page
                description = "Sample Application to demonstrate use and properties of swagger.", //description
                version = "1.0.0",  // version of your application
                contact = @Contact( // contact information of team
                        name = "Siddharth Katiyar",
                        email = "siddharth.dev177@gmail.com",
                        url = "<can mention url if any>"
                ),
                license = @License(
                        name = "<license_name>", url = "<license_url>"
                )
        )

)
@Tag(name = "SampleController", description = "This controller is created to provide details of all swagger properties")
public class SampleController {

    private final StudentService studentService;
    public SampleController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(
            summary = "Returns Hello World",
            description = "Simple Get API that returns Hello world!",
            tags = {"SampleController"},
            deprecated = true
    )
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @Operation(
            summary = "Get student using id",
            description = "Get student using unique ID",
            deprecated = false,
            responses = {
                    @ApiResponse(
                            description = "The student",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Student.class)
                            )
                    ),
                    @ApiResponse(
                            description = "Student not found.",
                            responseCode = "400"
                    )
            }
    )
    @GetMapping("/student/{id}")
    public Student getStudent(
            @Parameter(description = "Student ID", required = true)
            @PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student/add")
    @Operation(
            summary = "Add new student",
            description = "POST api to add new students",
            tags = "SampleController",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Student request body",
                    content = @Content(
                            schema = @Schema(implementation = Student.class)
                    )
            )
    )
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/student/{id}/{info}")
    public Object getStudentDetail(@PathVariable int id,
                                   @Parameter(description = "info of student that you need like name, courses etc", name = "info", example = "name") @PathVariable String info) {
        return studentService.getStudentDetail(id, info);
    }
}
