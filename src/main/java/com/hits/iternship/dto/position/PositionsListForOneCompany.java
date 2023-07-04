package com.hits.iternship.dto.position;

import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.students.StudentsShortDto;
import lombok.Data;

import java.util.List;

@Data
public class PositionsListForOneCompany {
    Integer positionId;
    Integer positionTypeId;
    String name;
    Integer plan;
    Integer taken;

    List<StudentsShortDto> students;
}
