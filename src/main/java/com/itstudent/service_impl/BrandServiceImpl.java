package com.itstudent.service_impl;

import com.itstudent.entities.data.Brand;
import com.itstudent.service.BaseService;
import com.itstudent.service.BrandService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BrandServiceImpl extends BaseService<Brand> implements BrandService {

    public BrandServiceImpl(JpaSpecificationExecutor<Brand> repo, EntityManager entityManager) {
        super(repo, Brand.class, entityManager);
    }
}
