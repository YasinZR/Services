package com.sdt.queryService.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "queries_images")
public class QueriesImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "name")
    @Getter@Setter
    private Image name;

    public QueriesImages(Integer id, Image name) {
        this.id = id;
        this.name = name;
    }
    public QueriesImages(){};

    @Override
    public String toString() {
        return "QueriesImages{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
