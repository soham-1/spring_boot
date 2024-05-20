package com.example.advanceJPA;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDetailsDAOImpl implements StudentDetailsDAO{
    EntityManager entityManager;

    @Autowired
    public StudentDetailsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public StudentDetails findStudentDetailsById(int id) {
        return entityManager.find(StudentDetails.class, id);
    }

    @Override
    @Transactional
    public void createStudentDetails(StudentDetails studentDetails) {
        entityManager.persist(studentDetails);
    }

    @Override
    @Transactional
    public void updateStudentDetails(StudentDetails studentDetails) {
        entityManager.merge(studentDetails);
    }

    @Override
    @Transactional
    public void deleteStudentDetailsById(int id) {
        StudentDetails studentDetails = findStudentDetailsById(id);
        entityManager.remove(studentDetails);
    }
}
