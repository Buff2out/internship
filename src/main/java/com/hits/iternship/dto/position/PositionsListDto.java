package com.hits.iternship.dto.position;

import com.hits.iternship.dto.companies.CompanyShortDto;
import lombok.Data;

import java.util.List;

@Data
public class PositionsListDto {

    Integer positionId;
    String name;
    Integer plan;
    Integer taken;

    List<CompanyShortDto> companies;

    public void setCompanies(List<CompanyShortDto> companies) {
        this.companies = companies;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public void setTaken(Integer taken) {
        this.taken = taken;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
