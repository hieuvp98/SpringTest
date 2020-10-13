package com.itstudent.entities.data;


import com.itstudent.entities.key.BillProductKey;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bill_has_product")
public class BillHasProduct {

    @EmbeddedId
    private BillProductKey id;
    private int amount;
    private double price;

    @ManyToOne
    @MapsId("productId") // tên của khoá ngoại trong EmbeddedId
    @JoinColumn(name = "product_id") // khoá ngoại
    private Product product;
}
