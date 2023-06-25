package com.hits.iternship.entities.interviews;

import com.hits.iternship.entities.comments.CommentEntity;
import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.position.PositionEntity;
import com.hits.iternship.entities.status.StatusEntity;
import com.hits.iternship.entities.students.StudentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "interviews")
public class InterviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(insertable=false, updatable=false)
    Integer interviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    StudentEntity student;
//    List<CompanyEntity> companies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    PositionEntity position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    StatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", referencedColumnName = "companyId") // Первое имя - хз что такое, второе - имя айди в классе репрезентетивитес
    CompanyEntity company;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewId", referencedColumnName = "interviewId")
    List<CommentEntity> comments;
}