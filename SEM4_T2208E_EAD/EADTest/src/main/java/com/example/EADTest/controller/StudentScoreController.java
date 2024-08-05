package com.example.EADTest.controller;

import com.example.EADTest.entity.Student;
import com.example.EADTest.entity.StudentScore;
import com.example.EADTest.entity.Subject;
import com.example.EADTest.service.StudentScoreService;
import com.example.EADTest.service.StudentService;
import com.example.EADTest.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("score")
public class StudentScoreController {
    private final StudentScoreService studentScoreService;
    private final StudentService studentService;
    private  final SubjectService subjectService;

    public StudentScoreController(StudentScoreService studentScoreService, StudentService studentService, SubjectService subjectService) {
        this.studentScoreService = studentScoreService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping("list")
    public String StudentList(Model model){
        List<StudentScore> studentScores = studentScoreService.getAllStudentScore();
        model.addAttribute("studentScores", studentScores);

        return "score/index";
    }

    @GetMapping("addForm")
    public String StudentCoreAddForm(Model model){
        StudentScore studentScore = new StudentScore();
        model.addAttribute("studentScore", studentScore);

        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);

        List<Subject> subjects = subjectService.getAllSubject();
        model.addAttribute("subjects", subjects);

        return "score/add";
    }

    @PostMapping("saveAdd")
    public String SaveAdd(@ModelAttribute StudentScore studentScore){
        studentScoreService.save(studentScore);
        return "redirect:/score/list";
    }
}
