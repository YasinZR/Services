package com.sdt.queryService.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "queries")
public class Queries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int areaId;

    private String status;
    // Добавляем поле для хранения результата
    private String result;
}
