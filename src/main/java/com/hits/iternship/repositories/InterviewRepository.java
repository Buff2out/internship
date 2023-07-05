package com.hits.iternship.repositories;

import com.hits.iternship.entities.interviews.InterviewEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.students.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<InterviewEntity, Integer> {
    List<InterviewEntity> findAll();

    InterviewEntity findInterviewEntityByInterviewId(Integer interviewId);
    List<StudentEntity> findStudentEntitiesByPositionCompanyEntity(PositionCompanyEntity positionCompanyEntity);
}