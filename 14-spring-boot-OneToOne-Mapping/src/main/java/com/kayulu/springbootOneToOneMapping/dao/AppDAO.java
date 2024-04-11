package com.kayulu.springbootOneToOneMapping.dao;

import com.kayulu.springbootOneToOneMapping.entity.Course;
import com.kayulu.springbootOneToOneMapping.entity.Instructor;
import com.kayulu.springbootOneToOneMapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    public void save(Instructor instructor);
    public Instructor findInstructorById(int id);
    public InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructor(int id);
    public void deleteInstructorDetail(int id);
    public void deleteInstructorDetailNoCascade(int id);
    public List<Course> findCoursesByInstructorId(int id);
    public Instructor findInstructorByIdJoinFetch(int id);
}
