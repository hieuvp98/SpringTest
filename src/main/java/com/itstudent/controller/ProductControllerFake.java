package com.itstudent.controller;

import com.itstudent.entities.data.Product;
import com.itstudent.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("api/public/products")
@AllArgsConstructor
public class ProductControllerFake {

    private final ProductRepo productRepo;

    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> post(@RequestBody Product product) {
//        product.setCategoryy(entityManager.getReference(Category.class, product.getCategoryy().getId()));
//        product.setBrand(entityManager.getReference(Brand.class, product.getBrand().getId()));
        entityManager.persist(product);
        return ResponseEntity.noContent().build();
    }
}
