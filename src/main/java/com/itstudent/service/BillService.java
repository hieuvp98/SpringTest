package com.itstudent.service;

import com.itstudent.entities.json.BillJson;
import com.itstudent.entities.payload.BillPayload;

public interface BillService {

    void save(BillPayload payload) throws Exception;

    BillJson findById(Integer billId) throws Exception;
}
