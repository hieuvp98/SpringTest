package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class BrandRepoImpl implements BrandRepoExample {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceContext
    private EntityManagerFactory factory;

    @Override
    public Brand findById(int id) {
        return entityManager.find(Brand.class, id);
    }

    @Override
    public List<Brand> findAll() {
        return null;
    }

    @Override
    public boolean insert(Brand brand) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            // code loạn xì ngầu
            entityTransaction.commit();
            return false;
        } catch (Exception e) {
            entityTransaction.rollback();
        }
        return false;
    }

    @Override
    public boolean update(Brand brand) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
