package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class DemoController {

    private EmployeeDAO employeeDAO;

    @Autowired
    public DemoController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
        int empId = employeeId == null ? 0 : employeeId.intValue();
        return employeeDAO.getEmployeeById(empId);
    }

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
        Employee employeeToSave = new Employee();
        employeeToSave.setFirstName(employee.getFirstName());
        employeeToSave.setLastName(employee.getLastName());
        employeeDAO.saveEmployee(employeeToSave);
    }

    @PutMapping
    public void updateEmployeeById(@RequestBody Employee employee) {
        Employee employeeFromDB = employeeDAO.getEmployeeById(employee.getId());
        employeeFromDB.setFirstName(employee.getFirstName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeDAO.updateEmployee(employeeFromDB);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId) {
        employeeDAO.deleteEmployeeById(employeeId);
    }

    @GetMapping("/search")
    public List<Employee> getEmployeesByFirstName(
            @RequestParam(name="firstName", required = false, defaultValue = "soham") String firstName) {
        return employeeDAO.getEmployeesByFirstName(firstName);
    }
}
