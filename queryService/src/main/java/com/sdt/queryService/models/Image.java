package com.sdt.queryService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

;

@Entity

@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private String name;

    public Image(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Image(){};

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
