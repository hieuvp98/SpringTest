package com.itstudent.controller;

import com.itstudent.entities.data.Brand;
import com.itstudent.repository.BrandRepoExample;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BrandControllerFake {

    private final BrandRepoExample brandRepo;

    @GetMapping("api/public/brands/{id}")
    public ResponseEntity<Brand> findById(@PathVariable("id") int id){
        return ResponseEntity.ok(brandRepo.findById(id));
    }
}
