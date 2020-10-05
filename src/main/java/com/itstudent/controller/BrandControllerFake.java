package com.itstudent.controller;

import com.itstudent.entities.data.Brand;
import com.itstudent.repository.BrandRepoExample;
import com.itstudent.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/public/brands")
public class BrandControllerFake {

    private final BrandRepoExample brandRepo;

    private final BrandRepository brandRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(brandRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById2(@PathVariable("id") int id ){
        return ResponseEntity.ok(brandRepo.findByIdSimple(id));
    }

    @PostMapping
    public ResponseEntity<String> upload(@RequestBody Brand brand) {
        brandRepository.count(Example.of(Brand.builder().deleted(false).build()));
        if (brandRepo.insert(brand))
            return ResponseEntity.ok("insert success");
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        if (brandRepo.delete(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().build();
    }
}
