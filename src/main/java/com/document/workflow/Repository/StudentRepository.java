package com.document.workflow.Repository;

import com.document.workflow.Entity.Document;
import com.document.workflow.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
