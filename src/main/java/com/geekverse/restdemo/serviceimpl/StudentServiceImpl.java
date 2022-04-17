package com.geekverse.restdemo.serviceimpl;

import com.geekverse.restdemo.dbentities.Student;
import com.geekverse.restdemo.jpa.StudentRepository;
import com.geekverse.restdemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public Student saveOrUpdate(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student retrieveStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent()?student.get():null;
    }

    @Override
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
