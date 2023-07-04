package com.hits.iternship.controllers;

import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.position.*;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.repositories.CompanyRepository;
import com.hits.iternship.repositories.PositionCompanyRepository;
import com.hits.iternship.repositories.PositionRepository;
import com.hits.iternship.service.CompanyService;
//import com.hits.iternship.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionsController {

//    private final PositionService positionService;

    private final CompanyService companyService;

    private final PositionRepository positionRepository;

    private final CompanyRepository companyRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private final PositionCompanyRepository positionCompanyRepository;
//    @PostMapping("/addPostion")
//    public PositionCompanyEntity addPosition(@RequestBody CreatePositionTypeDto createPositionTypeDtoEntity) {
//
//        PositionCompanyEntity positionEntity = positionService.createPosition(createPositionTypeDtoEntity);
//
//        return positionCompanyRepository.save(positionEntity);
//    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

//    @GetMapping()
    //public PositionsAllDto getAllPositions(@RequestBody PlanTakenDto planTakenDto) {
//    public PositionsAllDto getAllPositions() {
//
//        List<PositionsListDto> positionsListDtos =   positionService.findAllPositions(); //Вернулся лист дтошек ПОЗИТИОНС ЛИСТ
//
//        PositionsAllDto pos = new PositionsAllDto();
//      //  pos.setPlan(planTakenDto.getPlan());
//      //  pos.setTaken(planTakenDto.getTaken());
//
//        pos.setPlan(50);
//        pos.setTaken(20);
//
//        pos.setPositionCompanyEntities(positionsListDtos);
//        return pos;
//    }
    @GetMapping()
    public PositionsAllDto getAllPositions() {
        List<PositionEntity> positionEntities = positionRepository.findAll();
        List<PositionsListDto> positionsListDtos = new ArrayList<>();
        PositionsAllDto positionsAllDto = new PositionsAllDto();
        for (int i = 0; i < positionEntities.size(); i++) {
            List<PositionCompanyEntity> positionCompanyEntities = positionCompanyRepository.findPositionCompanyEntitiesByPositionEntity((positionEntities.get(i)));
//            System.out.println("_________positionCompanyEntities_________");
//            System.out.println(positionCompanyEntities);
//            System.out.println("_________positionEntities.get(i)_________");
//            System.out.println((positionEntities.get(i)));
//            System.out.println("_________(positionEntities.get(i)).getPositionCompanyEntities()_________");
//            System.out.println((positionEntities.get(i)).getPositionCompanyEntities());
            PositionsListDto positionsListDto = new PositionsListDto();
            List<CompanyShortDto> companyShortDtos = new ArrayList<>();
            for (int j = 0; j < positionCompanyEntities.size(); j++) {
                CompanyEntity companyEntity = (positionCompanyEntities.get(j)).getCompanyEntity();
                CompanyShortDto companyShortDto = new CompanyShortDto();
                companyShortDto.setCompanyId(companyEntity.getCompanyId());
                companyShortDto.setName(companyEntity.getName());
                companyShortDto.setPlan(0);
                companyShortDto.setTaken(0);
//                private Integer companyId;
//                private String name;
//                private int plan;
//                private int taken;
                companyShortDtos.add(companyShortDto);

                // CompanyShortDtos.push_back(CompanyShortDto)
            }
            positionsListDto.setPositionId((positionEntities.get(i)).getPositionId());
            positionsListDto.setName((positionEntities.get(i)).getName());
            positionsListDto.setPlan(0);
            positionsListDto.setTaken(0);
            positionsListDto.setCompanies(companyShortDtos);
            positionsListDtos.add(positionsListDto);
            // positionsListDtos.push_back(CompanyShortDtos)
        }
        positionsAllDto.setPlan(0);
        positionsAllDto.setTaken(0);
        positionsAllDto.setPositions(positionsListDtos);
        // приравняем к positionsAllDto.positions = positionsListDtos;
        return positionsAllDto;
    }
    @PostMapping()
    public List<PositionEntity> addNewPosition(@RequestBody PositionAddNewDto positionAddNewDto) {
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setName(positionAddNewDto.getName());
//        positionEntity.setPlan(0);
//        positionEntity.setTaken(0);
        positionRepository.save(positionEntity);
        List<PositionEntity> res = positionRepository.findAll();
        return res;
    }

}
