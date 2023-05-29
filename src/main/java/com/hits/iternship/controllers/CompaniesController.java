package com.hits.iternship.controllers;

import com.hits.iternship.dto.companies.CompanyFullDto;
import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.interview.InterviewOnCreateDto;
import com.hits.iternship.dto.position.*;
import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.dto.students.StudentsShortDto;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.companies.RepresentativesEntity;
import com.hits.iternship.entities.interviews.InterviewEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.entities.students.StudentEntity;
import com.hits.iternship.repositories.*;
import com.hits.iternship.service.CompanyService;
import com.hits.iternship.service.PositionService;
import com.hits.iternship.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompaniesController {




    private final CompanyService companyService;

    private final PositionService positionService;

    private final StudentService studentService;

    @GetMapping("/easy")
    public String easyMapping() {
        return "easy";
    }


    ///////////////////Методы добавления, которые не зеленые///////////////////////////////////////
    private final CompanyRepository companyRepository;

    private final RepresentativeRepository representativeRepository;

    private final ContactsRepository contactsRepository;

    private final StudentRepository studentRepository;

    private final PositionRepository positionRepository;

    private final InterviewRepository interviewRepository;

    @PostMapping("/addCompany")
    public CompanyEntity addCompany(@RequestBody CompanyEntity companyEntity){
        /*
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(name);
        companyEntity.setDescription(description);
        companyEntity.setImage(image);
        companyEntity.setPlan(plan);
        companyEntity.setTaken(taken);
        companyEntity.setRepresentatives(representatives);
        */
        try {
            List<RepresentativesEntity> repEnt = companyEntity.getRepresentatives();// лист наших представителей


            for (RepresentativesEntity oneRepEnt : repEnt
            ) {
                oneRepEnt.getContacts().stream().map(contactsRepository::save).toList(); // сохранение контактов представителей
            }
        }catch(Exception ex){
            companyRepository.save(companyEntity);
            return companyEntity;
        }


        companyEntity.getRepresentatives().stream().map(representativeRepository::save).toList();// сохранение представителей

        companyEntity.getContacts().stream().map(contactsRepository::save).toList(); // сохранение контактов компании

        companyRepository.save(companyEntity);
        return companyEntity;
    }


    @PostMapping("/addRepresentative")
    public RepresentativesEntity addRepresentative(@RequestBody RepresentativesEntity representativesEntity ){
    /*
        RepresentativesEntity representativesEntity = new RepresentativesEntity();
        representativesEntity.setName(name);
        representativesEntity.setPosition(position);
    */

        representativeRepository.save(representativesEntity);
        return representativesEntity;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping()
    public List<CompanyShortDto> getAllCompanies() {
        return companyService.findAllCompanies();
    }

    @GetMapping("/{companyId}")
    public List<CompanyFullDto> getCompanyById(@PathVariable Integer companyId){
        return companyService.findCompanyById(companyId);
    }

    @GetMapping("/{companyId}/positions")
    //public PositionsAllFonOneCompanyDto getPositionsForOneCompany(@PathVariable Integer companyId) {
    public PositionsAllFonOneCompanyDto getPositionsForOneCompany(@PathVariable Integer companyId) {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        CompanyEntity companyEntity = companyRepository.findCompanyEntityByCompanyId(companyId);

        List<StudentsShortDto> studentsShortDto = studentService.findAllShortStudents();
        List<PositionsListForOneCompany> positionsListDtos = positionService.findPositionsForOneCompany(companyId); //Вернулся лист дтошек ПОЗИТИОНС ЛИСТ
        List<StudentsShortDto> studentsShortFilterDto = new ArrayList<>();

        Integer correct_studId;
        Integer correct_posId;
        List<Integer> studPositionIdList = new ArrayList<>();
        List<Integer> companyPositionIdList = new ArrayList<>();
        List<Integer> studentsIdFiltret = new ArrayList<>();

        for (PositionsListForOneCompany temp_posforOneCompany : positionsListDtos
        ) {
            Integer positionId = temp_posforOneCompany.getPositionId();
            companyPositionIdList.add(positionId); // id позиций НАШЕЙ КОМПАНИИ
        }

        for (StudentEntity temp_stud : studentEntityList
        ) {
            /*
            for (PositionsListForOneCompany temp_posforOneCompany : positionsListDtos
            ) {
                Integer positionId = temp_posforOneCompany.getPositionId();
                companyPositionIdList.add(positionId); // id позиций НАШЕЙ КОМПАНИИ
            }
            */

            List<PositionEntity> position_list = temp_stud.getPositions();
            for (PositionEntity temp2 : position_list
            ) {

                //studentsIdFiltret.add();
                studPositionIdList.add(temp2.getPositionId()); // это id всех позиций конкретного студента
            }// нам нужно успеть спомощью листа studPositionIdList отфильтровать студентов и тут же очистить лист
            Integer companyPositionIdListSize = companyPositionIdList.size();
            Integer studPositionIdListSize = studPositionIdList.size();

            Integer bigestSize;
            Integer smolestSize;
            if(companyPositionIdListSize > studPositionIdListSize) {
                bigestSize = companyPositionIdListSize;
                smolestSize = studPositionIdListSize;
            }
            else {
                bigestSize = studPositionIdListSize;
                smolestSize = companyPositionIdListSize;
            }

            for (int i = 0; i < smolestSize; i++){
                for (int j = 0; j < smolestSize; j++){
                    if(companyPositionIdList.get(i) == studPositionIdList.get(j)){
                        StudentsShortDto tempStudentShortDto = studentService.findShortStudents(temp_stud);
                        studentsShortFilterDto.add(tempStudentShortDto);
                    }
                }
            }


            studPositionIdList = null;
        }
        for (PositionsListForOneCompany temp4 :positionsListDtos) {
            temp4.setStudents(studentsShortFilterDto);
        }


        List<StudentsShortDto> studentsShortForOneCompany = new ArrayList<>();


        PositionsAllFonOneCompanyDto pos = new PositionsAllFonOneCompanyDto();
        pos.setPlan(15);
        pos.setTaken(5);
        pos.setPositions(positionsListDtos);
        //pos.set
/*
        PositionsAllFonOneCompanyDto positionsAllFonOneCompanyDto = new PositionsAllFonOneCompanyDto();

        return positionsAllFonOneCompanyDto;

 */
        return pos;
    }


    @PostMapping("/{companyId}/positions/{positionId}")
    public InterviewOnCreateDto addInterview(@PathVariable Integer companyId, @PathVariable Integer positionId, @RequestBody InterviewOnCreateDto interviewOnCreateDto) {
        InterviewEntity interviewEntity = new InterviewEntity();
        interviewEntity.setCompany(companyRepository.findCompanyEntityByCompanyId(companyId));
        interviewEntity.setPosition(positionRepository.findPositionEntityByPositionId(positionId));
        //System.out.println(interviewOnCreateDto.getStudentId());
        interviewEntity.setStudent(studentRepository.findStudentEntityByStudentId(interviewOnCreateDto.getStudentId()));
        //interviewEntity.setStatus(statusRepository.findStatusEntityByStatusId(2).getStatus());
        //interviewEntity.setComments([]);
        interviewRepository.save(interviewEntity);
        return interviewOnCreateDto;
    }

}
