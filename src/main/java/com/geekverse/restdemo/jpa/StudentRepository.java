package com.geekverse.restdemo.jpa;

import com.geekverse.restdemo.dbentities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
