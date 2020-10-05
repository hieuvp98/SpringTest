package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>,
        JpaSpecificationExecutor<Brand>{

    List<Brand> findByNameContainsAndDeletedFalse(String name);

    List<Brand> findByIdInOrderByIdDesc(List<Integer> ids);

    @Modifying
    @Transactional
    long deleteBrandById(Integer id);

    @Query("from Brand b where b.id = :id and b.deleted = false")
    Optional<Brand> findById(@Param("id") int id);

    @Query("update Brand b set b.deleted = false where b.id = ?1")
    @Modifying
    @Transactional
    int customDelete(Integer id);
}