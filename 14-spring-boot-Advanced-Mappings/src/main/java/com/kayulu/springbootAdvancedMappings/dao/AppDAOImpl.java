package com.kayulu.springbootAdvancedMappings.dao;

import com.kayulu.springbootAdvancedMappings.entity.Course;
import com.kayulu.springbootAdvancedMappings.entity.Instructor;
import com.kayulu.springbootAdvancedMappings.entity.InstructorDetail;
import com.kayulu.springbootAdvancedMappings.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();

        for(Course course : courses)
            course.setInstructor(null);

        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetail);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailNoCascade(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        // first we need to brake the link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",
                Course.class
        ).setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.instructorDetail " +
                        "JOIN FETCH i.courses " +
                        "where i.id = :id",
                Instructor.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "join fetch c.reviews " +
                        "where c.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course courseToDelete = entityManager.find(Course.class, id);

        entityManager.remove(courseToDelete);
    }

    @Override
    @Transactional
    public void saveNewCourseNewStudents(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "join fetch c.students " +
                        "where c.id = :data", Course.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s " +
                "join fetch s.courses " +
                "where s.id = :data", Student.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
