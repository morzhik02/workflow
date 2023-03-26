package com.document.workflow.Service;

import com.document.workflow.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    Employee getEmployee(Long id);
    List<Employee> getEmployees();
    void deleteEmployee(Long id);
}
