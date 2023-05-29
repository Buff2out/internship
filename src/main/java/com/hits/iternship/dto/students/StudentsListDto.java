package com.hits.iternship.dto.students;

import com.hits.iternship.dto.StatusDto;
import com.hits.iternship.dto.companies.CompaniesStudentShortDto;
import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.position.PositionShortDto;
import com.hits.iternship.dto.position.PositionStudentShortDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class StudentsListDto {

    Integer studentId;

    String name;

    String image;



    Integer interviewsCount;

    List<CompaniesStudentShortDto> companies;

    StatusDto status;

    List<PositionStudentShortDto> positions;

    Date lastActivity;
}
