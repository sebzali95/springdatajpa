package com.example.springdatajpa.service;


import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }


    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Integer id, Student student) {
        Optional<Student> foundedStudent = studentRepository.findById(id);

        if (foundedStudent.isPresent()) {
            Student newStudent = foundedStudent.get();

            newStudent.setName(student.getName());
            newStudent.setSurname(student.getSurname());
            newStudent.setDateOfBirth(student.getDateOfBirth());
            newStudent.setStudentNumber(student.getStudentNumber());

            return studentRepository.save(newStudent);
        }
        return null;
    }



}
