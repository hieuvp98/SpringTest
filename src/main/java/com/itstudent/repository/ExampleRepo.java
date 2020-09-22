package com.itstudent.repository;

import com.itstudent.entities.data.Brand;

public interface ExampleRepo {

    Brand findById(int id);

    boolean insert(Brand brand);

    boolean update(Brand brand);

    boolean delete(int id);
}
