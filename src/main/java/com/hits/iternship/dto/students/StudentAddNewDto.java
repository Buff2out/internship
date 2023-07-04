package com.hits.iternship.dto.students;

import com.hits.iternship.dto.contacts.ContactsShortDto;
import com.hits.iternship.dto.interview.InterviewsDto;
import lombok.Data;

import java.util.List;

@Data
public class StudentAddNewDto {
    String name;

    public String getName() {
        return name;
    }
}
