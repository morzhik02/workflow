package com.document.workflow.Controller;

import com.document.workflow.Entity.Student;
import com.document.workflow.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id){
        return studentService.updateStudent(student, id);
    }

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> listAllDocuments(){
        List<Student> students = studentService.getStudents();
        return students;
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
}
