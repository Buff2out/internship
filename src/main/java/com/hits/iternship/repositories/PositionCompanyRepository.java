package com.hits.iternship.repositories;

import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionCompanyRepository extends JpaRepository<PositionCompanyEntity, Integer> {

    List<PositionCompanyEntity> findAll();

//    List<PositionCompanyEntity> findPositionCompanyEntitiesByCompanies(CompanyEntity companyEntity);

    PositionCompanyEntity findPositionCompanyEntityByPositionCompanyId(Integer positionId);
    List<PositionCompanyEntity> findPositionCompanyEntitiesByPositionEntity(PositionEntity positionEntity);


}
