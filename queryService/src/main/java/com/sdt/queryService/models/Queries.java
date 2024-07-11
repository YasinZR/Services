package com.sdt.queryService.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "queries")
public class Queries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private int areaId;
    @Getter@Setter
    private String status;

    public Queries(Integer id, int areaId, String status) {
        this.id = id;
        this.areaId = areaId;
        this.status = status;
    }
    public Queries(){};

    @Override
    public String toString() {
        return "Queries{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", status='" + status + '\'' +
                '}';
    }
}
