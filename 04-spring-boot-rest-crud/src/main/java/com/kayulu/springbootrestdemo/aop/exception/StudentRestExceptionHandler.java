package com.kayulu.springbootrestdemo.aop.exception;

import com.kayulu.springbootrestdemo.rest.StudentErrorResponse;
import com.kayulu.springbootrestdemo.rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
    The primary takeaway of this unit are:
        - Instead of the rest controller responsible for handling exceptions
            AOP can be used to outsource this responsibility. (sep of concerns)
        - the @ControllerAdvice turns a class into an AOP advice
        - an AOP advice intercepts each incoming requests enabling you to intercept bad requests before
            sending them to the controller.
        - a class annotated with @ControllerAdvice can be used to handle any exception thrown by a rest controller.
        - it's also possible to limit the scope of a @ControllerAdvice to specific packages or class by using
            the corresponding attributes
 */

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp) {
        StudentErrorResponse ser = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exp.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) {
        StudentErrorResponse ser = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exp.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(ser, HttpStatus.BAD_REQUEST);
    }
}
