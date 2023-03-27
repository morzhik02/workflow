package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Student;
import com.document.workflow.Repository.StudentRepository;
import com.document.workflow.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student oldStudent = studentRepository.getReferenceById(id);
        oldStudent.setUpdatedAt(LocalDateTime.now());
        oldStudent.setGroup_name(student.getGroup_name());
        return studentRepository.save(oldStudent);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
