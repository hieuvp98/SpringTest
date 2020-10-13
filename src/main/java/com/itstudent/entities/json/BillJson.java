package com.itstudent.entities.json;

import com.itstudent.entities.data.Bill;
import com.itstudent.entities.data.BillHasProduct;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BillJson {
    private Bill bill;
    private List<BillHasProduct> billHasProducts;
}
