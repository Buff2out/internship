package com.hits.iternship.repositories;

import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {

    List<PositionEntity> findAll();

    List<PositionEntity> findPositionEntitiesByCompanies(CompanyEntity companyEntity);

    PositionEntity findPositionEntityByPositionId(Integer positionId);


}
