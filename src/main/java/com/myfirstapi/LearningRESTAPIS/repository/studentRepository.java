package com.myfirstapi.LearningRESTAPIS.repository;

import com.myfirstapi.LearningRESTAPIS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student,Long> {

}
