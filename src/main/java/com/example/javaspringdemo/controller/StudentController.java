package com.example.javaspringdemo.controller;

import com.example.javaspringdemo.business.student.StudentService;
import com.example.javaspringdemo.data.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("api/v1/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("api/v1/students/create")
    public Student createStudent() {
        return studentService.createStudent();
    }
}
