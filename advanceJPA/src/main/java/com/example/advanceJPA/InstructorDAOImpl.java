package com.example.advanceJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Instructor findInstructorById(int id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        TypedQuery<Course> courseByInstructor = this.entityManager
                .createQuery("from Course where instructor.id=:instructor_id", Course.class);
        courseByInstructor.setParameter("instructor_id", id);

        return courseByInstructor.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> instructorTypedQuery = this.entityManager
                .createQuery("select i from Instructor i "
                + "join fetch i.courses "
                + "where i.id=:id", Instructor.class);
        instructorTypedQuery.setParameter("id", id);

        return instructorTypedQuery.getSingleResult();
    }
}
