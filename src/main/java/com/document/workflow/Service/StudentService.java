package com.document.workflow.Service;

import com.document.workflow.Entity.Document;
import com.document.workflow.Entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Student student, Long id);
    Student getStudent(Long id);
    List<Student> getStudents();
    void deleteStudent(Long id);
}
