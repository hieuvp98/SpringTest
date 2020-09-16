package com.itstudent.repository.example;

import com.itstudent.entities.data.Brand;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Data
public class BrandRepoExample_Impl implements BrandRepoExample {

    private final EntityManager entityManager;

    @Override
    public Brand findById(int id) {
        return entityManager.find(Brand.class, id);
    }

    @Override
    public List<Brand> findAll() {
        return null;
    }

    @Override
    public boolean insert(Brand brand) {
        return false;
    }

    @Override
    public boolean update(Brand brand) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
