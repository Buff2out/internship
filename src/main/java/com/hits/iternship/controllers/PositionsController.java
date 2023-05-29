package com.hits.iternship.controllers;

import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.position.*;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.repositories.PositionRepository;
import com.hits.iternship.service.CompanyService;
import com.hits.iternship.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionsController {

    private final PositionService positionService;

    private final CompanyService companyService;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private final PositionRepository positionRepository;
    @PostMapping("/addPostion")
    public PositionEntity addPosition(@RequestBody CreatePositionTypeDto createPositionTypeDtoEntity) {

        PositionEntity positionEntity = positionService.createPosition(createPositionTypeDtoEntity);

        return positionRepository.save(positionEntity);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping()
    //public PositionsAllDto getAllPositions(@RequestBody PlanTakenDto planTakenDto) {
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
}
