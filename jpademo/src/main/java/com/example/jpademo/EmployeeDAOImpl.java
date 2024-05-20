package com.example.jpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> getAllEmployeeQuery = this.entityManager.createQuery("From Employee", Employee.class);
        return getAllEmployeeQuery.getResultList();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return this.entityManager.find(Employee.class, employeeId);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeId) {
        Employee employee = getEmployeeById(employeeId);
        this.entityManager.remove(employee);
    }

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        TypedQuery<Employee> getEmployeesByFirstNameQuery = this.entityManager
                .createQuery("From Employee where firstName=:firstName", Employee.class);
        getEmployeesByFirstNameQuery.setParameter("firstName", firstName);
        return getEmployeesByFirstNameQuery.getResultList();
    }
}
