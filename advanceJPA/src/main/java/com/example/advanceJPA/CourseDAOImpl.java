package com.example.advanceJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createCourse(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void createCourse(Course course, int instructorId) {
        Instructor instructor = this.entityManager.find(Instructor.class, instructorId);
        course.setInstructor(instructor);
        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndStudentById(int id) {
        TypedQuery<Course> courseTypedQuery = this.entityManager.createQuery(
                "select c from Course c "
                + "join fetch c.students "
                + "where c.courseId = :id",
                Course.class
        );
        courseTypedQuery.setParameter("id", id);
        return courseTypedQuery.getSingleResult();
    }
}
