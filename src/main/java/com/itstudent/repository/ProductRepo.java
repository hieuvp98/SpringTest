package com.itstudent.repository;

import com.itstudent.entities.data.Product;
import com.itstudent.entities.query.CountProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("select new com.itstudent.entities.query.CountProduct(p.brand.name, count(p.id))" +
            " from Product p where p.deleted = false" +
            " group by p.brand")
    List<CountProduct> countProductByBrand();
}
