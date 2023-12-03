package com.kayulu.springbootrestdemo.rest;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(int studentId) {
        super("Student with id " + studentId + " not found");
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
