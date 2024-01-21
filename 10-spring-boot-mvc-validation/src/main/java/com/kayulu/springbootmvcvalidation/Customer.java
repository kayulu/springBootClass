package com.kayulu.springbootmvcvalidation;

import com.kayulu.springbootmvcvalidation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "must have at least one character")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 1, message = "Value must be greater than or equal to 1")
    @Max(value = 5, message = "Value must be less than or equal to 5")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "must be exactly 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "AI_", message = "must start with AI_")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
