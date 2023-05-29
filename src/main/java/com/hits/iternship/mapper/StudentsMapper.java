package com.hits.iternship.mapper;

import com.hits.iternship.dto.StatusDto;
import com.hits.iternship.dto.companies.CompaniesStudentShortDto;
import com.hits.iternship.dto.contacts.ContactsShortDto;
import com.hits.iternship.dto.position.PositionStudentShortDto;
import com.hits.iternship.dto.position.PositionsTypesAllDto;
import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.dto.students.StudentsShortDto;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.entities.status.StatusEntity;
import com.hits.iternship.entities.students.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StudentsMapper {

    private final ModelMapper modelMapper;

/*
НИЖЕ МОЙ МЕТОД СТУДЕНТСЛИСТДТО


    public List<StudentsListDto> toStudentsListDto(List<StudentEntity> studentEntityList) {


        List<StudentsListDto> studentsListDtosEnd = new ArrayList<>();

        StudentsListDto studentsListDto;

        StudentsListDto studentsListDtoLAST = new StudentsListDto();

      //  List<CompanyEntity> companyEntityList = new ArrayList<>();
        List<CompaniesStudentShortDto> companiesStudentShortDtoList = new ArrayList<>();
        List<PositionStudentShortDto> studentPositionList = new ArrayList<>();
        //  StatusDto statusDtoAll;
      //  List<StudentEntity> studentEntityListEnd = new ArrayList<>();
        for(StudentEntity studentEntity:studentEntityList)   {
            StatusEntity statusEntity = studentEntity.getStatus();
            StatusDto statusDto = modelMapper.map(statusEntity, StatusDto.class);
            //     statusDtoAll = statusDto;
            List<CompanyEntity> oneStudentCompanyList = studentEntity.getCompanies();
            for(CompanyEntity companyEntity: oneStudentCompanyList)
            {

                CompaniesStudentShortDto firstCompanyStudentShortDto = modelMapper.map(companyEntity, CompaniesStudentShortDto.class);
                companiesStudentShortDtoList.add(firstCompanyStudentShortDto);

                studentsListDto = modelMapper.map(studentEntity, StudentsListDto.class);
                studentsListDto.setCompanies(companiesStudentShortDtoList);

                studentsListDtoLAST = studentsListDto;
            }



            List<PositionEntity> oneStudentPositionList = studentEntity.getPositions();
            for(PositionEntity positionEntity: oneStudentPositionList)
            {

                PositionStudentShortDto firstPositionStudentShortDto = modelMapper.map(positionEntity, PositionStudentShortDto.class);
                studentPositionList.add(firstPositionStudentShortDto);

                studentsListDto = modelMapper.map(studentEntity, StudentsListDto.class);
                studentsListDto.setPositions(studentPositionList);

                studentsListDtoLAST = studentsListDto;

            }

            /*

            studentsListDto = modelMapper.map(studentEntity, StudentsListDto.class); // здесь 1 зампаленный студент
            studentsListDto.setCompanies(companiesStudentShortDtoList);
            studentsListDto.setPositions(studentPositionList);
            //   studentsListDto.setStatus(statusDtoAll);
           // ТУТ ВКОРЯЧИТЬ ЗАВЕРШЕНИЕ СТРОЧНОГО КОММЕНТА ()

          //  studentsListDtosEnd.add(studentsListDto);// сюда складываем замапленных студентов


            studentsListDtosEnd.add(studentsListDtoLAST);

        }

        return studentsListDtosEnd;

        //StudentsListDto studentsListDtoList = modelMapper.map(studentEntityList, StudentsListDto.class);
    }
*/


    public List<StudentsListDto> toStudentsListDto(List<StudentEntity> studentEntityList) {


        List<StudentsListDto> studentsListDtosEnd = new ArrayList<>();

        StudentsListDto studentsListDto;

        StudentsListDto studentsListDtoLAST = new StudentsListDto();

        //  List<CompanyEntity> companyEntityList = new ArrayList<>();

        //  StatusDto statusDtoAll;
        //  List<StudentEntity> studentEntityListEnd = new ArrayList<>();
        for(StudentEntity studentEntity:studentEntityList)   {
            StatusEntity statusEntity = studentEntity.getStatus();
            //StatusDto statusDto = modelMapper.map(statusEntity, StatusDto.class);
            //     statusDtoAll = statusDto;
            List<CompanyEntity> oneStudentCompanyList = studentEntity.getCompanies();
            studentsListDto = modelMapper.map(studentEntity, StudentsListDto.class);
            List<CompaniesStudentShortDto> companiesStudentShortDtoList = new ArrayList<>();
            for(CompanyEntity companyEntity: oneStudentCompanyList)
            {

                CompaniesStudentShortDto firstCompanyStudentShortDto = modelMapper.map(companyEntity, CompaniesStudentShortDto.class);
                companiesStudentShortDtoList.add(firstCompanyStudentShortDto);




                studentsListDtoLAST = studentsListDto;
            }
            studentsListDto.setCompanies(companiesStudentShortDtoList);


            List<PositionStudentShortDto> studentPositionList = new ArrayList<>();
            List<PositionEntity> oneStudentPositionList = studentEntity.getPositions();
            for(PositionEntity positionEntity: oneStudentPositionList)
            {

                PositionStudentShortDto firstPositionStudentShortDto = modelMapper.map(positionEntity, PositionStudentShortDto.class);
                studentPositionList.add(firstPositionStudentShortDto);

                //studentsListDto = modelMapper.map(studentEntity, StudentsListDto.class);


                studentsListDtoLAST = studentsListDto;

            }
            studentsListDto.setPositions(studentPositionList);

            /*

            studentsListDto = modelMapper.map(studentEntity, StudentsListDto.class); // здесь 1 зампаленный студент
            studentsListDto.setCompanies(companiesStudentShortDtoList);
            studentsListDto.setPositions(studentPositionList);
            //   studentsListDto.setStatus(statusDtoAll);
            */

            //  studentsListDtosEnd.add(studentsListDto);// сюда складываем замапленных студентов


            studentsListDtosEnd.add(studentsListDto);

        }

        return studentsListDtosEnd;

        //StudentsListDto studentsListDtoList = modelMapper.map(studentEntityList, StudentsListDto.class);
    }




    public List<StudentsShortDto> toStudentsShortDto(List<StudentEntity> studentEntityList) {
        List<StudentsShortDto> studentsShortDtosEnd = new ArrayList<>();

        StudentsShortDto studentsShortDto;

        StudentsListDto studentsListDtoLAST = new StudentsListDto();

        for(StudentEntity studentEntity:studentEntityList)   {
            StatusEntity statusEntity = studentEntity.getStatus();
            StatusDto statusDto = modelMapper.map(statusEntity, StatusDto.class);
            studentsShortDto = modelMapper.map(studentEntity, StudentsShortDto.class);
            studentsShortDtosEnd.add(studentsShortDto);
        }
        return studentsShortDtosEnd;
    }

    public StudentsShortDto toOneStudentsShortsDto(StudentEntity studentEntity){
        StatusEntity statusEntity = studentEntity.getStatus();
        StatusDto statusDto = modelMapper.map(statusEntity, StatusDto.class);
        StudentsShortDto studentsShortDto = modelMapper.map(studentEntity, StudentsShortDto.class);
        return studentsShortDto;
    }
}
