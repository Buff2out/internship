package com.hits.iternship.controllers;

import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.entities.students.StudentEntity;
import com.hits.iternship.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

StudentService studentService;
    @GetMapping()
//    public List<StudentsListDto> getAllStudents() {
    public List<StudentEntity> getAllStudents() {




        return studentService.findAllStudents();
    }
}
