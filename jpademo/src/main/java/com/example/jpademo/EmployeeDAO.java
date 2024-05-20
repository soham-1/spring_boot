package com.example.jpademo;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int employeeId);

    List<Employee> getEmployeesByFirstName(String firstName);
}
