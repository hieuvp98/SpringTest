package com.itstudent.repository.interfac;

import com.itstudent.entities.data.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

    List<Brand> findByNameContainsOrderByNameDesc(String name);

    List<Brand> findByNameContainsAndDeleted(String name, Boolean a);

    @Modifying
    @Transactional
    int deleteById(int id);



}