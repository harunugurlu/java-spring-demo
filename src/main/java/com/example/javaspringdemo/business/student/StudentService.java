package com.example.javaspringdemo.business.student;

import com.example.javaspringdemo.data.entity.Student;
import com.example.javaspringdemo.data.repository.StudentRepository;
import com.example.javaspringdemo.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public Optional<Student> updateStudent(StudentDTO studentDTO, Long id) throws Exception {
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

        return Optional.of(studentRepository.save(student.get()));
    }

    public Optional<Student> deleteStudent(Long id) throws Exception{
        if(id <= 0) {
            throw new Exception("Invalid student id: " + id);
        }
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()) {
            throw new Exception("Student with id: " + id + " is not found");
        }
        studentRepository.deleteById(id);
        return student;
    }
}
