package com.itstudent.entities.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean deleted;
}
