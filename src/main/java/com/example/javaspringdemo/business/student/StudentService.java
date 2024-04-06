package com.example.javaspringdemo.business.student;

import com.example.javaspringdemo.data.entity.Student;
import com.example.javaspringdemo.data.repository.StudentRepository;
import com.example.javaspringdemo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student updateStudent(StudentDTO studentDTO) throws Exception {
        Long id = studentDTO.getId();
        if(id <= 0) {
            throw new Exception("Invalid student id: " + id);
        }
        Optional<Student> student = studentRepository.findById(studentDTO.getId());
        if(!student.isPresent()) {
            throw new Exception("Student with id: " + id + " is not found");
        }
        student.ifPresent(std -> {
            std.setName(studentDTO.getName());
            std.setEmail(studentDTO.getEmail());
            std.setDateOfBirth(studentDTO.getDateOfBirth());
        });

        return studentRepository.save(student.get());
    }
}
