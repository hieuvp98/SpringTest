package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Repository
public class RepoTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(rollbackFor = {Exception.class}, timeout = 10)
    public void insert(Brand brand) {
        entityManager.persist(brand);
    }
}
