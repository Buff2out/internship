package com.hits.iternship.entities.position;

import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.students.StudentEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "positions")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer positionId;


    String name;

    public void setName(String name) {
        this.name = name;
    }

//    int plan;
//
//    int taken;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionsId", referencedColumnName = "positionId")
    List<CompanyEntity> companies;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionsId", referencedColumnName = "positionId")
    List<StudentEntity> students;

}
