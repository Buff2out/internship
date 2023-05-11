package com.hits.iternship.service;

import com.hits.iternship.dto.students.StudentsListDto;
import com.hits.iternship.entities.students.StudentEntity;
import com.hits.iternship.repositories.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    StudentsRepository studentsRepository;

//    public List<StudentsListDto> findAllStudents() {
    public List<StudentEntity> findAllStudents() {
        // List<StudentEntity> studentEntityList = studentsRepository.findAll();
        // вызвать mapper и замаппить из studententity в studentlistDto
        // затем вернуть полученное в контроллер
        return studentsRepository.findAll();
    }
}
