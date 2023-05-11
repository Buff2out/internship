package com.hits.iternship.mapper;

import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.students.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StudentsMapper {
    ModelMapper modelMapper;
//    public StudentsListDto toStudentsListDto(StudentEntity studentEntity) {
//        List<StudentsListDto> studentEntities =
//                modelMapper.map(studentEntity, StudentsListDto.class);
//    }
}
