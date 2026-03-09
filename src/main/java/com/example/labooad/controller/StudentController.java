package com.example.labooad.controller;

import com.example.labooad.model.Student;
import com.example.labooad.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Student());

        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student){

        service.addStudent(student);

        return "redirect:/";
    }
}