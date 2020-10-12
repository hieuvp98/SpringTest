package com.itstudent.repository;


import com.itstudent.entities.data.Brand;
import com.itstudent.entities.query.CountProduct;
import com.itstudent.entities.query.QueryBrand;

import java.util.List;

public interface BrandRepoExample {

    Brand findById(int id) throws Exception;
    Brand findById2(int id);
    QueryBrand findByIdSimple(int id);
    Object[] findByIdSimple2(int id);
    List<Brand> findAll();
    List<Brand> findAll2();
    List<Brand> findByName(String name);
    Long count();
    boolean insert(Brand brand);
    boolean update(Brand brand);
    boolean delete(int id);
    List<Integer> findAllIds();
    List<CountProduct> countProduct();
}
