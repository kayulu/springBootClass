package com.kayulu.springbootrestdemo.rest;

import com.kayulu.springbootrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> allStudents; // my in-memory db

    @PostConstruct  // will be called
    public void populateStudents() {
        allStudents = List.of( // immutable structure
                new Student("Kay", "Ulu"),
                new Student("Ser", "Jo"),
                new Student("Sel", "Kit"),
                new Student("Clare", "Kit"));
    }

    // Note that behind the scenes Jackson does all the
    // serialization and deserialization work between Json and Java Objects.

    // RestClient <-> Jackson <-> RestController
    @GetMapping("/students")
    private List<Student> getAllStudents() {
        return allStudents;
    }

    @GetMapping("/students/{studentId}")
    private Student getStudentById(@PathVariable("studentId") int studId) {
        return allStudents.stream()
                .skip(studId)
                .findFirst()
                .orElse(new Student("DEFAULT", "STUDENT"));
    }
}
