package com.hits.iternship.service;

import com.hits.iternship.dto.position.CreatePositionTypeDto;
import com.hits.iternship.dto.position.PositionsAllDto;
import com.hits.iternship.dto.position.PositionsListDto;
import com.hits.iternship.dto.position.PositionsListForOneCompany;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.companies.RepresentativesEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.mapper.PositionsMapper;
import com.hits.iternship.repositories.CompanyRepository;
import com.hits.iternship.repositories.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    private final CompanyRepository companyRepository;

    private final PositionsMapper positionsMapper;


   // public CreatePositionTypeDto createPosition(PositionEntity positionEntity){
//   public PositionEntity createPosition(CreatePositionTypeDto createPositionTypeDto){
//
//       List<Integer> companiesId = createPositionTypeDto.getCompaniesId();
//
//       PositionEntity posEntMap = positionsMapper.toPositionEntity(createPositionTypeDto); // лист ентетей позиций без компаний
//       List<CompanyEntity> allCompaniesList = new ArrayList<>();
//        for(Integer i : companiesId){
//            CompanyEntity companyEntitiesList = companyRepository.findCompanyEntityByCompanyId(i);
//
//            allCompaniesList.add(companyEntitiesList);
//        }
//       posEntMap.setCompanies(allCompaniesList);
//
//       /*
//            List<CompanyEntity> companiesEntities = positionEntity.getCompanies();// лист наших представителей
//            List<Integer> companiesId = new ArrayList<>();
//            for(CompanyEntity companiesEntity : companiesEntities) {
//                int i = 0;
//                CompanyEntity firstCompany = companiesEntities.get(i);
//                Integer companyId =  firstCompany.getCompanyId();
//                companiesId.add(companyId); // ТОТ ЛИСТЫЙ, КОТОРЫЙ НАДО БУДЕТ ДОБАВИТЬ К МОЕЙ ДТОШКЕ С ПОЗИЦИЯМИ
//            }
//*/
//
//       return posEntMap;
//    }

    public List<PositionsListDto> findAllPositions()
    {
        List<PositionEntity> AllPositionsEntities = positionRepository.findAll();
        List<PositionsListDto> positionsListDtos = new ArrayList<>();
        for(PositionEntity positionEntity:AllPositionsEntities) {
            positionsListDtos.add(positionsMapper.toPositionsListDto(positionEntity));
        }


        return positionsListDtos;
    }

    //public List<PositionsListForOneCompany> findPositionsForOneCompany(Integer companyId){
    public List<PositionsListForOneCompany> findPositionsForOneCompany(Integer companyId){


       CompanyEntity companyEntity = companyRepository.findCompanyEntityByCompanyId(companyId);




        List<PositionEntity> positionsEntities = positionRepository.findPositionEntitiesByCompanies(companyEntity); //позиции вычесленные по айди компании - а именно позиции компании
        List<PositionsListForOneCompany> positionsListDtos = new ArrayList<>();
        for(PositionEntity positionEntity:positionsEntities) {
            positionsListDtos.add(positionsMapper.toPositionsListForOneCompany(positionEntity));
        }
        /*
        List<PositionsListForOneCompany> positionsListForOneCompanies = new ArrayList<>();
        return positionsListForOneCompanies;
        */
         return positionsListDtos;
    }


}
