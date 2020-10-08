package com.itstudent.repository;

import com.itstudent.entities.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByCategory_IdAndBrand_IdAndNameContains
            (Integer cateId, Integer brandId, String name);

    @Query("from Product  p where p.category.id = ?1 and p.brand.id = ?2 and " +
            "p.name like concat('%',?3,'%')")
    List<Product> findByCateAndBrandAndNameLike
            (Integer cateId, Integer brandId, String name);
}
