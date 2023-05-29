package com.hits.iternship.dto.students;

import com.hits.iternship.dto.StatusDto;
import lombok.Data;

import java.util.Date;
@Data
public class StudentsShortDto {

     Integer studentId;

     String name;

     StatusDto status;

     Date lastActivity;
}
