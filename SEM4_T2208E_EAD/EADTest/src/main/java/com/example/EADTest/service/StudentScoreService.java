package com.example.EADTest.service;

import com.example.EADTest.entity.StudentScore;
import com.example.EADTest.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentScoreService implements IStudentScoreService{
    private final StudentScoreRepository studentScoreRepository;

    @Autowired
    public StudentScoreService(StudentScoreRepository studentScoreRepository) {
        this.studentScoreRepository = studentScoreRepository;
    }

    @Override
    public List<StudentScore> getAllStudentScore() {
        return studentScoreRepository.findAll();
    }

    @Override
    public Optional<StudentScore> getStudentScoreById(Integer id) {
        return studentScoreRepository.findById(id);
    }

    @Override
    public void save(StudentScore studentScore) {
        studentScoreRepository.save(studentScore);
    }

    @Override
    public void delete(Integer id) {
        studentScoreRepository.deleteById(id);
    }
}
