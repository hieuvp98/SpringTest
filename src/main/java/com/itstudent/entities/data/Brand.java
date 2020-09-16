package com.itstudent.entities.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "backend_class",name = "brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private Boolean deleted;
}
