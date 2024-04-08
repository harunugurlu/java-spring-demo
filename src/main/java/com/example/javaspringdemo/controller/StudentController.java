package com.example.javaspringdemo.controller;

import com.example.javaspringdemo.business.student.StudentService;
import com.example.javaspringdemo.data.entity.Student;
import com.example.javaspringdemo.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        Student student = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("api/v1/students/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) throws Exception {
        Student updatedStudent = studentService.updateStudent(studentDTO, id)
                .orElseThrow(() -> new Exception("Student not found with id " + id));
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("api/v1/students/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) throws Exception {
        Student deletedStudent = studentService.deleteStudent(id).orElseThrow(() -> new Exception("Student not found with id: " + id));
        return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
    }
}
