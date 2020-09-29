package com.itstudent.entities.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //... some properties

    @ManyToMany
    @JoinTable(name = "bill_has_product", // tên bảng trung gian
            joinColumns = @JoinColumn(name = "bill_id"), // khoá ngoại đến Entity hiện tại
            inverseJoinColumns = @JoinColumn(name = "product_id")) // khoá ngoại đến Entity liên kết
    private List<Product> products;
}
