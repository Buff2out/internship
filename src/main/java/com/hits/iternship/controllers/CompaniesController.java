package com.hits.iternship.controllers;

import com.hits.iternship.dto.StatusDto;
import com.hits.iternship.dto.comments.CommentOnCreateDto;
import com.hits.iternship.dto.companies.CompanyShortDto;
import com.hits.iternship.dto.interview.InterviewOnCreateDto;
import com.hits.iternship.dto.position.*;
import com.hits.iternship.dto.students.StudentsShortDto;
import com.hits.iternship.entities.comments.CommentEntity;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.companies.RepresentativesEntity;
import com.hits.iternship.entities.interviews.InterviewEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.entities.students.StudentEntity;
import com.hits.iternship.repositories.*;
import com.hits.iternship.service.CompanyService;
//import com.hits.iternship.service.PositionService;
import com.hits.iternship.service.StudentService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompaniesController {




    private final CompanyService companyService;

//    private final PositionService positionService;

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

    private final PositionCompanyRepository positionCompanyRepository;
    private final PositionRepository positionRepository;

    private final InterviewRepository interviewRepository;
    private final CommentRepository commentRepository;

    @PostMapping()
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


    @PostMapping("/representative")
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
    public CompanyEntity getCompanyById(@PathVariable Integer companyId){
        return companyRepository.findCompanyEntityByCompanyId(companyId);
    }

    @GetMapping("/{companyId}/positions")
    public PositionsAllFonOneCompanyDto getAllPositionsOfCompany(@PathVariable Integer companyId) {
//        List<PositionCompanyEntity> positionCompanyEntities = positionCompanyRepository.findPositionCompanyEntitiesByCompanyEntity(companyRepository.findCompanyEntityByCompanyId(companyId));
        List<PositionCompanyEntity> positionCompanyEntities = positionCompanyRepository.findPositionCompanyEntitiesByCompanyEntity(companyRepository.findCompanyEntityByCompanyId(companyId));
        List<PositionsListForOneCompany> positionsListForOneCompany = new ArrayList<>();
        PositionsAllFonOneCompanyDto positionsAllFonOneCompanyDto = new PositionsAllFonOneCompanyDto();
        for (int i = 0; i < positionCompanyEntities.size(); i++) {
//            StudentEntity studentEntity =  positionCompanyRepository.findStudentEntitiesByPositionCompanyId(i+1);
//            PositionCompanyEntity positionCompanyEntity = positionCompanyRepository.findPositionCompanyEntityByPositionCompanyId(i+1);
            List<Tuple> studentTuples = studentRepository.findStudentEntitiesByPosId(i+1);
            List<StudentsShortDto> studentsShortDtos = studentTuples.stream()
                    .map(t -> new StudentsShortDto(
                            t.get(0, Integer.class),
                            t.get(1, String.class),
                            t.get(2, String.class),
                            t.get(3, Date.class)
                    ))
                    .collect(Collectors.toList());
//            System.out.println(positionCompanyEntity);
            // WARNING
//            System.out.println(studentEntities);
//            System.out.println("_________positionEntities.get(i)_________");
//            System.out.println((positionEntities.get(i)));
//            System.out.println("_________(positionEntities.get(i)).getPositionCompanyEntities()_________");
//            System.out.println((positionEntities.get(i)).getPositionCompanyEntities());
            PositionsListForOneCompany positionListForOneCompany = new PositionsListForOneCompany();
//            List<StudentsShortDto> studentsShortDtos = new ArrayList<>();
//            for (int j = 0; j < studentEntities.size(); j++) {
////                CompanyEntity companyEntity = (positionCompanyEntities.get(j)).getCompanyEntity();
//                StudentsShortDto studentsShortDto = new StudentsShortDto();
//                studentsShortDto.setStudentId((studentEntities.get(j)).getStudentId());
//                studentsShortDto.setName((studentEntities.get(j)).getName());
////                Integer studentId;
////                String name;
////                StatusDto status;
////                Date lastActivity;
//                studentsShortDtos.add(studentsShortDto);
//
//                // CompanyShortDtos.push_back(CompanyShortDto)
//            }

//            Integer positionId;
//            String name;
//            Integer plan;
//            Integer taken;
//            List<StudentsShortDto> students;
            positionListForOneCompany.setPositionId((positionCompanyEntities.get(i)).getPositionCompanyId());
            PositionEntity positionEntity = (positionCompanyEntities.get(i)).getPositionEntity();

            positionListForOneCompany.setName(positionEntity.getName());
            positionListForOneCompany.setPositionTypeId(positionEntity.getPositionId());
            positionListForOneCompany.setStudents(studentsShortDtos);
            positionListForOneCompany.setPlan(0);
            positionListForOneCompany.setTaken(0);
            positionsListForOneCompany.add(positionListForOneCompany);
            // positionsListDtos.push_back(CompanyShortDtos)
            // WARNING
        }
        positionsAllFonOneCompanyDto.setPlan(0);
        positionsAllFonOneCompanyDto.setTaken(0);
        positionsAllFonOneCompanyDto.setPositionsListForOneCompany(positionsListForOneCompany);
        // приравняем к positionsAllDto.positions = positionsListDtos;
        return positionsAllFonOneCompanyDto;
    }
//    //public PositionsAllFonOneCompanyDto getPositionsForOneCompany(@PathVariable Integer companyId) {
//    public PositionsAllFonOneCompanyDto getPositionsForOneCompany(@PathVariable Integer companyId) {
////        List<StudentEntity> studentEntityList = studentRepository.findAll();
////        CompanyEntity companyEntity = companyRepository.findCompanyEntityByCompanyId(companyId);
////
////        List<StudentsShortDto> studentsShortDto = studentService.findAllShortStudents();
////        List<PositionsListForOneCompany> positionsListDtos = positionService.findPositionsForOneCompany(companyId); //Вернулся лист дтошек ПОЗИТИОНС ЛИСТ
////        List<StudentsShortDto> studentsShortFilterDto = new ArrayList<>();
////
////        Integer correct_studId;
////        Integer correct_posId;
////        List<Integer> studPositionIdList = new ArrayList<>();
////        List<Integer> companyPositionIdList = new ArrayList<>();
////        List<Integer> studentsIdFiltret = new ArrayList<>();
////
////        for (PositionsListForOneCompany temp_posforOneCompany : positionsListDtos
////        ) {
////            Integer positionId = temp_posforOneCompany.getPositionId();
////            companyPositionIdList.add(positionId); // id позиций НАШЕЙ КОМПАНИИ
////        }
////
////        for (StudentEntity temp_stud : studentEntityList
////        ) {
////            /*
////            for (PositionsListForOneCompany temp_posforOneCompany : positionsListDtos
////            ) {
////                Integer positionId = temp_posforOneCompany.getPositionId();
////                companyPositionIdList.add(positionId); // id позиций НАШЕЙ КОМПАНИИ
////            }
////            */
////
////            List<PositionCompanyEntity> position_list = temp_stud.getPositionCompanyEntities();
////            for (PositionCompanyEntity temp2 : position_list
////            ) {
////
////                //studentsIdFiltret.add();
////                studPositionIdList.add(temp2.getPositionId()); // это id всех позиций конкретного студента
////            }// нам нужно успеть спомощью листа studPositionIdList отфильтровать студентов и тут же очистить лист
////            Integer companyPositionIdListSize = companyPositionIdList.size();
////            Integer studPositionIdListSize = studPositionIdList.size();
////
////            Integer bigestSize;
////            Integer smolestSize;
////            if(companyPositionIdListSize > studPositionIdListSize) {
////                bigestSize = companyPositionIdListSize;
////                smolestSize = studPositionIdListSize;
////            }
////            else {
////                bigestSize = studPositionIdListSize;
////                smolestSize = companyPositionIdListSize;
////            }
////
////            for (int i = 0; i < smolestSize; i++){
////                for (int j = 0; j < smolestSize; j++){
////                    if(companyPositionIdList.get(i) == studPositionIdList.get(j)){
////                        StudentsShortDto tempStudentShortDto = studentService.findShortStudents(temp_stud);
////                        studentsShortFilterDto.add(tempStudentShortDto);
////                    }
////                }
////            }
////
////
////            studPositionIdList = null;
////        }
////        for (PositionsListForOneCompany temp4 :positionsListDtos) {
////            temp4.setStudents(studentsShortFilterDto);
////        }
////
////
////        List<StudentsShortDto> studentsShortForOneCompany = new ArrayList<>();
////
////
////        PositionsAllFonOneCompanyDto pos = new PositionsAllFonOneCompanyDto();
////        pos.setPlan(15);
////        pos.setTaken(5);
////        pos.setPositionCompanyEntities(positionsListDtos);
////        //pos.set
/////*
////        PositionsAllFonOneCompanyDto positionsAllFonOneCompanyDto = new PositionsAllFonOneCompanyDto();
////
////        return positionsAllFonOneCompanyDto;
////
//// */
////        return pos;
//
//    }
//    @GetMapping("/{companyId}/positions")
//    public PositionEntity getPositionsForOneCompany(@PathVariable Integer companyId) {
//        PositionEntity positionEntity =
//
//    }
    @PostMapping("/{id}/positions")
    public List<PositionCompanyEntity> addPosition(@PathVariable Integer id, @RequestBody PositionCompanyAddNewDto positionCompanyAddNewDto) {
        PositionCompanyEntity positionCompanyEntity = new PositionCompanyEntity();
        Integer positionId = positionCompanyAddNewDto.getPositionTypeId();
        positionCompanyEntity.setPositionEntity(positionRepository.findPositionEntityByPositionId(positionId));
        positionCompanyEntity.setCompany(companyRepository.findCompanyEntityByCompanyId(id));
        positionCompanyEntity.setPlan(positionCompanyAddNewDto.getPlan());
//        List<CompanyEntity> companyEntities = new ArrayList<>();
//        companyEntities.add(companyRepository.findCompanyEntityByCompanyId(id));
//        positionCompanyEntity.setCompanies(companyEntities);
//        PositionCompanyEntity positionCompanyEntity = positionService.createPosition(positionCompanyAddNewDto);
        positionCompanyRepository.save(positionCompanyEntity);
        List<PositionCompanyEntity> res = positionCompanyRepository.findAll();
        return res;
    }


    @PostMapping("/{companyId}/positions/{positionCompanyId}")
    public InterviewOnCreateDto addInterview(@PathVariable Integer companyId, @PathVariable Integer positionCompanyId, @RequestBody InterviewOnCreateDto interviewOnCreateDto) {
        InterviewEntity interviewEntity = new InterviewEntity();
        interviewEntity.setCompany(companyRepository.findCompanyEntityByCompanyId(companyId));
        interviewEntity.setPosition(positionCompanyRepository.findPositionCompanyEntityByPositionCompanyId(positionCompanyId));
        //System.out.println(interviewOnCreateDto.getStudentId());
        interviewEntity.setStudent(studentRepository.findStudentEntityByStudentId(interviewOnCreateDto.getStudentId()));
        //interviewEntity.setStatus(statusRepository.findStatusEntityByStatusId(2).getStatus());
        //interviewEntity.setComments([]);
        interviewRepository.save(interviewEntity);
        return interviewOnCreateDto;
    }

    @PostMapping("/{companyId}/interviews/{interviewId}/comments")
    public CommentOnCreateDto addCommentToInterviewId(@PathVariable Integer companyId, @PathVariable Integer interviewId, @RequestBody CommentOnCreateDto commentOnCreateDto) {
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());

        CommentEntity commentEntity = new CommentEntity();
//        commentEntity.setUser(companyRepository.findCompanyEntityByCompanyId(companyId));
        commentEntity.setText(commentOnCreateDto.getText());
//        commentEntity.setTimestamp(timestamp2);
        commentEntity.setInterviewEntity(interviewRepository.findInterviewEntityByInterviewId(interviewId));
        commentRepository.save(commentEntity);
        return commentOnCreateDto;
    }

}
