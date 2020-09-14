package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BrandRepository extends JpaRepository<Brand, Integer>,
        JpaSpecificationExecutor<Brand> {

}