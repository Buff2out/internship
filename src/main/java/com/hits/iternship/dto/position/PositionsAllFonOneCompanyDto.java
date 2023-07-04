package com.hits.iternship.dto.position;

import lombok.Data;

import java.util.List;
@Data
public class PositionsAllFonOneCompanyDto {

    Integer plan;

    Integer taken;

    List<PositionsListForOneCompany> positionsListForOneCompany;

    public void setPositionsListForOneCompany(List<PositionsListForOneCompany> positionsListForOneCompany) {
        this.positionsListForOneCompany = positionsListForOneCompany;
    }
}
