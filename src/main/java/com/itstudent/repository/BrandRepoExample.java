package com.itstudent.repository;


import com.itstudent.entities.data.Brand;

import java.util.List;

public interface BrandRepoExample {

    public Brand findById(int id) throws Exception;
    public List<Brand> findAll();
    public List<Brand> findByName(String name);
    public Long count();
    public boolean insert(Brand brand);
    public boolean update(Brand brand);
    public boolean delete(int id);
}
