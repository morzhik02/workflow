package com.document.workflow.Repository;

import com.document.workflow.Entity.News;
import com.document.workflow.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
