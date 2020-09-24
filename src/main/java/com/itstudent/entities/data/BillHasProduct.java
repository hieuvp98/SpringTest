package com.itstudent.entities.data;


import com.itstudent.entities.key.BillProductKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bill_has_product")
public class BillHasProduct {

    @EmbeddedId
    private BillProductKey id;

    private int amount;

    private double price;
}
