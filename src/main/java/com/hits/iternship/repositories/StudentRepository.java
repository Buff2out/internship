package com.hits.iternship.repositories;

import com.hits.iternship.entities.students.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findAll();

    StudentEntity findStudentEntityByStudentId(Integer studentId);
}
