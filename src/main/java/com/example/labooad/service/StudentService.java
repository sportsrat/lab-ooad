package com.example.labooad.service;

import com.example.labooad.model.Student;
import com.example.labooad.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public void addStudent(Student student){

        if(repo.existsByEmail(student.getEmail())){
            throw new RuntimeException("Duplicate email");
        }

        repo.save(student);
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }
}