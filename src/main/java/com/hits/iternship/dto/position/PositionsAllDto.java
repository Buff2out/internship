package com.hits.iternship.dto.position;

import lombok.Data;

import java.util.List;

@Data
public class PositionsAllDto {
    Integer plan;

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    Integer taken;

    public void setTaken(Integer taken) {
        this.taken = taken;
    }

    List<PositionsListDto> positions;

    public void setPositions(List<PositionsListDto> positions) {
        this.positions = positions;
    }
}
