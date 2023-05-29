package com.hits.iternship.repositories;

import com.hits.iternship.entities.status.StatusEntity;
import com.hits.iternship.entities.students.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

    StudentEntity findStatusEntityByStatusId(Integer statusId);
}
