package com.example.javaspringdemo.controller;

import com.example.javaspringdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("api/v1/students")
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L, "harun", 23, LocalDate.of(2001, 3, 1), "harunugurlu-x@outlook.com"
                )
        );
    }
}
