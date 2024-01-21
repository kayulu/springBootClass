package com.kayulu.springbootmvcvalidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface CourseCode {
    String message() default "Course Code must start with LUV";
    String value() default "LUV";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
