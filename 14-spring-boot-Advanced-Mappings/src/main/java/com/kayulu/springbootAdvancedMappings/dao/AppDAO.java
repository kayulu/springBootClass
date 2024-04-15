package com.kayulu.springbootAdvancedMappings.dao;

import com.kayulu.springbootAdvancedMappings.entity.Course;
import com.kayulu.springbootAdvancedMappings.entity.Instructor;
import com.kayulu.springbootAdvancedMappings.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    public void save(Instructor instructor);
    public Instructor findInstructorById(int id);
    public InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructorById(int id);
    public void deleteInstructorDetail(int id);
    public void deleteInstructorDetailNoCascade(int id);
    public List<Course> findCoursesByInstructorId(int id);
    public Instructor findInstructorByIdJoinFetch(int id);
    public void update(Instructor instructor);
    public Course findCourseById(int id);
    public void update(Course course);
    public void deleteCourseById(int id);
    public void save(Course course);
}
