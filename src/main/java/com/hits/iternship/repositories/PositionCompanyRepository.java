package com.hits.iternship.repositories;

import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.entities.students.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionCompanyRepository extends JpaRepository<PositionCompanyEntity, Integer> {

    List<PositionCompanyEntity> findAll();
//    List<PositionCompanyEntity> findPositionCompanyEntitiesByCompanyEntity();

//    List<PositionCompanyEntity> findPositionCompanyEntitiesByCompanies(CompanyEntity companyEntity);
//    positionsListForOneCompany
    PositionCompanyEntity findPositionCompanyEntityByPositionCompanyId(Integer positionId);
    List<PositionCompanyEntity> findPositionCompanyEntitiesByCompanyEntity(CompanyEntity companyEntity);
    List<PositionCompanyEntity> findPositionCompanyEntitiesByPositionEntity(PositionEntity positionEntity);
    PositionEntity findPositionEntityByPositionCompanyId(Integer positionId);

    List<StudentEntity> findStudentEntitiesByPositionCompanyId(Integer positionId);

    List<StudentEntity> findStudentEntitiesByPositionCompanyEntity(PositionCompanyEntity positionCompanyEntity);

//    List<StudentEntity> findStudentEntitiesByPositionCompanyId(Integer positionId);


}
