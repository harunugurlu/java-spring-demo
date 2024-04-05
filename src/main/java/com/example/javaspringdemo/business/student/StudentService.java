package com.example.javaspringdemo.business.student;

import com.example.javaspringdemo.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L, "harun", 23, LocalDate.of(2001, 3, 1), "harunugurlu-x@outlook.com"
                )
        );
    }
}
