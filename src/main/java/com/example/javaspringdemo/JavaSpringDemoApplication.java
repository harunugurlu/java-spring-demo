package com.example.javaspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class JavaSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringDemoApplication.class, args);
    }

    @GetMapping
    public List<String> hello() {
        return List.of("Hello there!", "Welcome to the app.");
    }
}
