package com.hits.iternship.dto.students;

import com.hits.iternship.dto.StatusDto;
import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.position.PositionShortDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class StudentsListDto {

    Integer studentId;

    String name;

    String image;

    StatusDto status;

    int interviewsCount;

    List<CompanyShortDto> companies;

    List<PositionShortDto> positions;

    Date lastActivity;
}
