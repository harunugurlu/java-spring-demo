package com.example.javaspringdemo.business.student;

import com.example.javaspringdemo.data.entity.Student;
import com.example.javaspringdemo.data.repository.StudentRepository;
import com.example.javaspringdemo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getName(), studentDTO.getDateOfBirth(), studentDTO.getEmail()
        );
        return studentRepository.save(student);
    }
}
