package com.hits.iternship.mapper;

import com.hits.iternship.dto.position.CreatePositionTypeDto;
import com.hits.iternship.dto.position.PositionsListDto;
import com.hits.iternship.dto.position.PositionsListForOneCompany;
import com.hits.iternship.dto.position.PositionsTypesAllDto;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PositionsMapper {
    private final ModelMapper modelMapper;

    public PositionsTypesAllDto toPositionsTypesAllDto(PositionCompanyEntity positionCompanyEntity) {
        return Objects.isNull(positionCompanyEntity) ? null :
                modelMapper.map(positionCompanyEntity, PositionsTypesAllDto.class);
    }


    public CreatePositionTypeDto toCreatePositionTypeDto(PositionCompanyEntity positionCompanyEntity) {
        return Objects.isNull(positionCompanyEntity) ? null :
                modelMapper.map(positionCompanyEntity, CreatePositionTypeDto.class);
    }

    public PositionCompanyEntity toPositionEntity(CreatePositionTypeDto createPositionTypeDto) {
        return Objects.isNull(createPositionTypeDto) ? null :
                modelMapper.map(createPositionTypeDto, PositionCompanyEntity.class);
    }

    public PositionsListDto toPositionsListDto(PositionCompanyEntity positionCompanyEntity)
    {
        return Objects.isNull(positionCompanyEntity) ? null :
                modelMapper.map(positionCompanyEntity, PositionsListDto.class);
    }

    public PositionsListForOneCompany toPositionsListForOneCompany(PositionCompanyEntity positionCompanyEntity)
    {
        return Objects.isNull(positionCompanyEntity) ? null :
                modelMapper.map(positionCompanyEntity, PositionsListForOneCompany.class);
    }


}
