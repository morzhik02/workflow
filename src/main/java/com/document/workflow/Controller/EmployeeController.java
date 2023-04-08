package com.document.workflow.Controller;

import com.document.workflow.Entity.Employee;
import com.document.workflow.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id){
        return employeeService.updateEmployee(employee, id);
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> listAllEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        return employees;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
