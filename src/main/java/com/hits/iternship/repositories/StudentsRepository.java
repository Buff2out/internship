package com.hits.iternship.repositories;

import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.entities.students.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<StudentEntity,Integer> {
    // method (void) save exist
    List<StudentEntity> findAll();
}
