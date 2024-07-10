package com.sdt.queryService.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "queries_images")
public class QueriesImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "name")
    private Image name;
}
