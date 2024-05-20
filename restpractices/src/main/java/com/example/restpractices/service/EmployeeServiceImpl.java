package com.example.restpractices.service;

import com.example.restpractices.dao.EmployeeRepository;
import com.example.restpractices.entity.Employee;
import com.example.restpractices.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with given id not found");
        }

        return employee.get();
    }

    @Transactional
    @Override
    public Employee createEmployee(Employee employee) {
        Employee emp = new Employee();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        return employeeRepo.save(emp);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDB = employeeRepo.findById(employee.getId());
        if (employeeDB.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with given id not found");
        }
        Employee emp = employeeDB.get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        return employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepo.deleteById(id);
    }
}
