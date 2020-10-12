package com.itstudent.repository;

import com.itstudent.entities.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> findByCategory_IdAndBrand_IdAndDeletedFalse
            (Integer cateId, Integer brandId);

    @Query("from Product p where (p.category.id = ?1 or ?1 = 0) and p.brand.id = ?2 and " +
            "p.name like concat('%',?3,'%')")
    List<Product> findByCateAndBrandAndNameLike
            (Integer cateId, Integer brandId, String name);
}
