package com.itstudent.repository.interfac;

import com.itstudent.entities.data.BillHasProduct;
import com.itstudent.entities.key.BillProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface BillHasProductRepo extends JpaRepository<BillHasProduct,BillProductKey> {

    List<BillHasProduct> findById_BillId(Integer billId);
}
