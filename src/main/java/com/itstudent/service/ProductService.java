package com.itstudent.service;

import com.itstudent.entities.data.Product;
import com.itstudent.repository.ProductRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ProductService extends BaseService<Product> {

    public ProductService(ProductRepo repo, EntityManager entityManager) {
        super(repo, Product.class, entityManager);
    }
}
