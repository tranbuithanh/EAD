package com.example.EADTest.controller;

import com.example.EADTest.entity.Student;
import com.example.EADTest.entity.StudentScore;
import com.example.EADTest.entity.Subject;
import com.example.EADTest.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("list")
    public String StudentList(Model model){
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("addForm")
    public String StudentCoreAddForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "student/add";
    }

    @PostMapping("saveAdd")
    public String SaveAdd(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }
}
