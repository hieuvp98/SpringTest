package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class BrandRepoImpl implements BrandRepoExample {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    EntityManagerFactory factory;

    @Override
    public Brand findById(int id) throws Exception{
       TypedQuery<Brand> query =
               entityManager.createQuery("select b from Brand b " +
                "where b.id = :id " +
                "and b.deleted = false", Brand.class);
       query.setParameter("id", id);
       return query.getSingleResult();
    }

    @Override
    public List<Brand> findAll() {
        return entityManager
                .createQuery("select b from Brand b " +
                        "where b.deleted = false ").getResultList();
    }

    @Override
    public List<Brand> findByName(String name) {
        Query query = entityManager
                .createQuery("select b from Brand b" +
                        " where b.name like concat('%',?1,'%')");
        query.setParameter(1, name);
        return query.getResultList();
    }

    @Override
    public Long count() {
        return entityManager.createQuery("select count(b) " +
                "from Brand b where b.deleted = false", Long.class)
                .getSingleResult();
    }

    @Override
    @Transactional
    public boolean insert(Brand brand) {
        brand.setId(null);
        entityManager.persist(brand);
        return true;
    }

    @Override
    public boolean update(Brand brand) {
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Query query = entityManager
                .createQuery("update Brand b" +
                        " set b.deleted = true where b.id = ?1");
        query.setParameter(1, id);
        return query.executeUpdate() > 0;
    }
}
