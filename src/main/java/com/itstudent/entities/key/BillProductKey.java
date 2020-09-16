package com.itstudent.entities.key;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
@Data
public class BillProductKey implements Serializable {

    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "product_id")
    private Integer productId;
}
