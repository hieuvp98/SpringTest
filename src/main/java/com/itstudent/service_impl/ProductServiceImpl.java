package com.itstudent.service_impl;

import com.itstudent.entities.data.Product;
import com.itstudent.service.BaseService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ProductServiceImpl extends BaseService<Product> {

    public ProductServiceImpl(JpaSpecificationExecutor<Product> repo, EntityManager entityManager) {
        super(repo, Product.class, entityManager);
    }
}
