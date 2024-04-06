package com.example.javaspringdemo.business.student;

import com.example.javaspringdemo.data.entity.Student;
import com.example.javaspringdemo.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent() {
        Student student = new Student(
                "harun", LocalDate.of(2001, 3, 1), "harunugurlu-x@outlook.com"
        );

        return studentRepository.save(student);
    }
}
