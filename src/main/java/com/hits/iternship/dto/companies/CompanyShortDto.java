package com.hits.iternship.dto.companies;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

// вроде найз
@Data
public class CompanyShortDto {

    private Integer companyId;

    private String name;

    private int plan;

    private int taken;

}
