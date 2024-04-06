package com.example.javaspringdemo.controller;

import com.example.javaspringdemo.business.student.StudentService;
import com.example.javaspringdemo.data.entity.Student;
import com.example.javaspringdemo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Student createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("api/v1/students/update")
    public Student updateStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return studentService.updateStudent(studentDTO);
    }
}
