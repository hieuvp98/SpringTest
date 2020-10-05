package com.itstudent.entities.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "deleted")
    private Boolean deleted;

}
