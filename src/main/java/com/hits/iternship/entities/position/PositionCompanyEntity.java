package com.hits.iternship.entities.position;

import com.hits.iternship.entities.companies.CompanyEntity;
import com.hits.iternship.entities.students.StudentEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "positioncompanies")
public class PositionCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer positionCompanyId;

    int plan;

    public void setPlan(int plan) {
        this.plan = plan;
    }

    int taken;

    public void setTaken(int taken) {
        this.taken = taken;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    CompanyEntity companyEntity;

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompany(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentsId", referencedColumnName = "studentsId")
    List<StudentEntity> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    PositionEntity positionEntity;

    public void setPositionEntity(PositionEntity positionEntity) {
        this.positionEntity = positionEntity;
    }
}
