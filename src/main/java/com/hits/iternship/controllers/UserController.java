package com.hits.iternship.controllers;

import com.hits.iternship.dto.students.StudentAddNewDto;
import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.entities.comments.UserEntity;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.status.StatusEntity;
import com.hits.iternship.entities.students.StudentEntity;
import com.hits.iternship.repositories.StudentRepository;
import com.hits.iternship.repositories.UserRepository;
import com.hits.iternship.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    private final StudentService studentService;

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
//    @GetMapping()
//    public List<StudentsListDto> getAllStudents() {
//
//
//        return studentService.findAllStudents();
//
//    }
    @PostMapping()
    public StudentAddNewDto addUser(@RequestBody StudentAddNewDto studentAddNewDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(studentAddNewDto.getName());
        userRepository.save(userEntity);
        return studentAddNewDto;
    }

    @GetMapping()
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

//    @GetMapping("/test")
//    public String getTest() {
//
//        List<StudentEntity> studentEntityList = studentRepository.findAll();
//        for(StudentEntity studentEntity: studentEntityList)
//        {
//            StatusEntity status = studentEntity.getStatus();
//            if(status != null)
//            {
//                int i = 0;
//            }
//            List<CompanyEntity> company =  studentEntity.getCompanies();
//            if(company != null)
//            {
//                int i = 0;
//            }
//            List<PositionCompanyEntity> positionEntities = studentEntity.getPositionCompanyEntities();
//            if(positionEntities != null)
//            {
//                int i = 0;
//            }
//
//            studentEntity.getName();
//        }
//        if(studentEntityList != null) {
//            return "ok";
//        }else{
//            return "not ok";
//        }
//
//
//    }

}
