package com.geekverse.restdemo.controller;

import com.geekverse.restdemo.dbentities.Student;
import com.geekverse.restdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/savenew")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student saved = studentService.saveOrUpdate(student);
        return new ResponseEntity<Student>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updated = studentService.saveOrUpdate(student);
        return new ResponseEntity<Student>(updated,HttpStatus.ACCEPTED);
    }

    @GetMapping({"","/","/list"})
    public ResponseEntity<List<Student>> retrieveAll() {
        List<Student> list = studentService.retrieveAllStudents();
        return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> retrieveOneStudent(@PathVariable("id") Long id) {
        Student student = studentService.retrieveStudent(id);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }
}
