package com.itstudent.entities.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillProductKey implements Serializable {

    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "product_id")
    private Integer productId;
}
