package com.itstudent.repository.example;

import com.itstudent.entities.data.Brand;

import java.util.List;

public interface BrandRepoExample {

    public Brand findById(int id);

    public List<Brand> findAll();

    public boolean insert(Brand brand);

    public boolean update(Brand brand);

    public boolean delete(int id);
}
