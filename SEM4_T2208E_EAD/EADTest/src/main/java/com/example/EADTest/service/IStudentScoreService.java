package com.example.EADTest.service;

import com.example.EADTest.entity.StudentScore;

import java.util.List;
import java.util.Optional;

public interface IStudentScoreService {
    public List<StudentScore> getAllStudentScore();
    public Optional<StudentScore> getStudentScoreById(Integer id);
    public void save(StudentScore studentScore);
    public void delete(Integer id);
}
