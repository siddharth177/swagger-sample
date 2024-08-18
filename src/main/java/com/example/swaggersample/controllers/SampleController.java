package com.example.swaggersample.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@OpenAPIDefinition(
        info = @Info(
                title = "Swagger Sample Application",
                description = "Sample Application to demonstrate use and properties of swagger.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Siddharth Katiyar",
                        email = "siddharth.dev177@gmail.com"

                )
        )
)
@Tag(name = "SampleController", description = "This controller is created to provide details of all swagger properties")
public class SampleController {

    @Operation(
            summary = "Returns Hello World",
            description = "Simple Get API that returns Hello world!",
            tags = {"SampleController"}
    )
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
