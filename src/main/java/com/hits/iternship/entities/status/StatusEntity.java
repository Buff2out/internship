package com.hits.iternship.entities.status;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "statuses")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer statusId;

    String type;

    int number;
}
