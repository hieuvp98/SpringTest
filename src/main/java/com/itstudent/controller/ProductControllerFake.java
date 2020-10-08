package com.itstudent.controller;

import com.itstudent.entities.data.Product;
import com.itstudent.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("api/public/products")
@AllArgsConstructor
public class ProductControllerFake {

    private EntityManager entityManager;

    private ProductRepo productRepo;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> post(@RequestBody Product product) {
        entityManager.persist(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<Object> filter(@RequestParam("category") Integer cateId,
                                         @RequestParam("brand") Integer brandId,
                                         @RequestParam("name") String name) {
        return ResponseEntity.ok(productRepo
                .findByCategory_IdAndBrand_IdAndNameContains(cateId, brandId, name));
    }
}
