package com.document.workflow.Repository;

import com.document.workflow.Entity.Employee;
import com.document.workflow.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
