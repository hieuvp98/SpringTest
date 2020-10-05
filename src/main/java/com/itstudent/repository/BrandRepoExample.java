package com.itstudent.repository;


import com.itstudent.entities.data.Brand;
import com.itstudent.entities.query.CountProduct;
import com.itstudent.entities.query.QueryBrand;

import java.util.List;

public interface BrandRepoExample {

    public Brand findById(int id) throws Exception;
    QueryBrand findByIdSimple(int id);
    Object[] findByIdSimple2(int id);
    public List<Brand> findAll();
    public List<Brand> findByName(String name);
    public Long count();
    public boolean insert(Brand brand);
    public boolean update(Brand brand);
    public boolean delete(int id);
    List<Integer> findAllIds();
    List<CountProduct> countProduct();
}
