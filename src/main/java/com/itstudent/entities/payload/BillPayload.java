package com.itstudent.entities.payload;

import com.itstudent.entities.data.Bill;
import lombok.Data;

import java.util.List;

@Data
public class BillPayload {
    private Bill bill;
    private List<ProductInBill> productInBills;
}
