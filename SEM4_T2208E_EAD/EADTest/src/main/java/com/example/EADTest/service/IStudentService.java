package com.example.EADTest.service;

import com.example.EADTest.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> getAllStudent();
    public Optional<Student> getStudentById(Integer id);
    public void save(Student student);
    public void delete(Integer id);
}
