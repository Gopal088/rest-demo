package com.geekverse.restdemo.service;

import com.geekverse.restdemo.dbentities.Student;

import java.util.List;

public interface StudentService {

    public Student saveOrUpdate(Student student);
    public Student retrieveStudent(Long id);
    public List<Student> retrieveAllStudents();
    public void deleteStudent(Long id);
}
