package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Employee;
import com.document.workflow.Repository.EmployeeRepository;
import com.document.workflow.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee student, Long id) {
        Employee oldEmployee = employeeRepository.getReferenceById(id);
        oldEmployee.setUpdatedAt(LocalDateTime.now());
        oldEmployee.setGroup_name(student.getGroup_name());
        return employeeRepository.save(oldEmployee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
