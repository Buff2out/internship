package com.hits.iternship.repositories;


import com.hits.iternship.entities.companies.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository  extends JpaRepository<CompanyEntity, Integer>{

    List<CompanyEntity> findAll();

   // List<CompanyEntity> searchCompanyEntitiesByDescription(String description);

    //List<CompanyEntity> findCompanyEntitiesByCompanyId(Integer companyId);

    List<CompanyEntity> findCompanyEntitiesByCompanyId(Integer companyId);

    CompanyEntity findCompanyEntityByCompanyId(Integer companyId);



}
