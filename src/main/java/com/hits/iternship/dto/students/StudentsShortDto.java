package com.hits.iternship.dto.students;

//import com.hits.iternship.dto.Statu;
import lombok.Data;

import java.util.Date;
@Data
public class StudentsShortDto {

     Integer studentId;

     String name;

     String status;

     Date lastActivity;

     public StudentsShortDto(Integer integer, String s, String s1, Date date) {
          studentId = integer;
          name = s;
          lastActivity = date;
          status = s1;
     }
}
