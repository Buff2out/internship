package com.hits.iternship.entities.students;

import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.interviews.InterviewEntity;
import com.hits.iternship.entities.position.PositionCompanyEntity;
import com.hits.iternship.entities.status.StatusEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer studentId;

    String name;

    String image;


    Integer InterviewsCount;

//    @OneToMany(fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId") //Один студент может пробовать себя во многих компаниях, но вот по итогу работать будет только в одной. Да и вообще в компаниях мы не отображаем студентов, так что тут оне ту мени
    List<CompanyEntity> companies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    StatusEntity status;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "positionCompanyId", referencedColumnName = "positionCompanyId") //Один студент может пробовать себя во многих компаниях, но вот по итогу работать будет только в одной. Да и вообще в компаниях мы не отображаем студентов, так что тут оне ту мени
//    List<PositionCompanyEntity> positionCompanyEntities;


    /////////////////////////////////////////////
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    List<InterviewEntity> interviews;

    ////////////////////////////////////////////////////////////////////

    Date lastActivity;



    // List<ContactsEntity> contacts;




}

