package com.kayulu.springbootmvcvalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    String prefix;

    @Override
    public void initialize(CourseCode courseCode) {
        ConstraintValidator.super.initialize(courseCode);
        prefix = courseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        // code is not required
        return code == null || (code.startsWith(prefix));
    }
}
