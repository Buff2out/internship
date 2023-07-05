package com.hits.iternship.repositories;

import com.hits.iternship.dto.students.StudentsFromInterviewsShortDto;
import com.hits.iternship.dto.students.StudentsShortDto;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.students.StudentEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findAll();

    StudentEntity findStudentEntityByStudentId(Integer studentId);

    // TODO interviews.status_id AS status, last_activity AS lastactivity
    @Query(
            value = "SELECT students.student_id AS studentId, name, interviews.status_id AS status, last_activity AS lastActivity FROM students " +
                    "JOIN interviews " +
                    "ON interviews.student_id = students.student_id " +
                    "WHERE interviews.position_company_id = :position",
            nativeQuery = true)
    List<Tuple> findStudentEntitiesByPosId(@Param("position") Integer position);


}
