package com.hits.iternship.controllers;

import com.hits.iternship.dto.position.*;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.repositories.PositionCompanyRepository;
import com.hits.iternship.repositories.PositionRepository;
import com.hits.iternship.service.CompanyService;
import com.hits.iternship.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionsController {

    private final PositionService positionService;

    private final CompanyService companyService;

    private final PositionRepository positionRepository;

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

    @GetMapping()
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
//        pos.setPositions(positionsListDtos);
//        return pos;
//    }
    public PositionsAllDto getAllPositions() {

        List<PositionsListDto> positionsListDtos =   positionService.findAllPositions(); //Вернулся лист дтошек ПОЗИТИОНС ЛИСТ

        PositionsAllDto pos = new PositionsAllDto();
        //  pos.setPlan(planTakenDto.getPlan());
        //  pos.setTaken(planTakenDto.getTaken());

        pos.setPlan(50);
        pos.setTaken(20);

        pos.setPositions(positionsListDtos);
        return pos;
    }
    @PostMapping()
    public List<PositionEntity> addNewPosition(@RequestBody PositionAddNewDto positionAddNewDto) {
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setName(positionAddNewDto.getName());
        positionEntity.setPlan(0);
        positionEntity.setTaken(0);
        positionRepository.save(positionEntity);
        List<PositionEntity> positionEntities =  positionRepository.findAll();
        return positionEntities;
    }

}
