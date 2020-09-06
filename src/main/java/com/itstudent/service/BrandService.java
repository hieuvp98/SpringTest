package com.itstudent.service;

import com.itstudent.entities.data.Brand;
import com.itstudent.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BrandService extends BaseService<Brand>{

    @Autowired
    public BrandService(BrandRepo repo, EntityManager entityManager) {
        super(repo,Brand.class, entityManager);
    }
}
