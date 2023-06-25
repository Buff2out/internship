package com.hits.iternship.dto.position;

import lombok.Data;

import java.util.List;

public class PositionAddNewDto {
    String postionTypeId;

    public String getPostionTypeId() {
        return postionTypeId;
    }

    Integer plan;

    public Integer getPlan() {
        return plan;
    }
}
