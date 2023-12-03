package com.kayulu.springbootrestdemo.rest;

import com.kayulu.springbootrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
    The primary takeaway of this unit are:
        - during request handling exceptions can occur
        - for custom exceptions a class representing this exception can be implemented (StudentNotFoundException)
        - handling an exceptions can be done in methods annotated with @ExceptionHandler
        - to provide a response to the client a ResponseEntity object can be returned in the exception handler
        - Jackson converts the response object automatically to JSON
 */

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

        return Optional.ofNullable(studId < 0 || allStudents.size() <= studId ? null : allStudents.get(studId))
                .orElseThrow(() -> new StudentNotFoundException(studId));
    }

    // This is the handler for our custom exception. It returns a ResponseEntity of StudentErrorResponse
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp) {
        StudentErrorResponse ser = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exp.getMessage(),
                System.currentTimeMillis());

        // A ResponseEntity is a class that represents an HTTP response, allowing you to control the response status code,
        // headers, and body content returned from a RESTful web service endpoint. It's a flexible way to
        // customize and build HTTP responses in your application.
        return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);
    }

    // generic handler for all types of Exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) {
        StudentErrorResponse ser = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exp.getMessage(),   // customize the message here if needed
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(ser, HttpStatus.BAD_REQUEST);
    }
}
