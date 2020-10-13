package com.itstudent.repository.impl;

import com.itstudent.entities.data.Brand;
import com.itstudent.entities.query.CountProduct;
import com.itstudent.entities.query.QueryBrand;
import com.itstudent.repository.interfac.BrandRepoExample;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BrandRepoImpl implements BrandRepoExample {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    EntityManagerFactory factory;

    @Override
    public Brand findById(int id) throws Exception {
        TypedQuery<Brand> query = entityManager
                .createQuery("select b from Brand b" +
                        " where b.id = :id and b.deleted = false", Brand.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Brand findById2(int id) {
        // tạo jpql query
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);
        Predicate predicate = builder.equal(root.get("id"), id);
        criteriaQuery.select(root).where(predicate);
        //
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public QueryBrand findByIdSimple(int id) {
        TypedQuery<QueryBrand> query = entityManager
                .createQuery("select new com.itstudent" +
                                ".entities.query.QueryBrand(b.id,b.name)" +
                                " from Brand b" +
                                " where b.id = :id and b.deleted = false",
                        QueryBrand.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Object[] findByIdSimple2(int id) {
        TypedQuery<Object[]> query = entityManager
                .createQuery("select b.id,b.name" +
                                " from Brand b" +
                                " where b.id = :id and b.deleted = false",
                        Object[].class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Brand> findAll() {
        Query query =
                entityManager.createQuery(
                        "select b from Brand b where b.deleted = false");
        query.setMaxResults(5);
        return query.getResultList();
    }

    @Override
    public List<Brand> findAll2() {
        // tạo jpql query
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);
        criteriaQuery.select(root);
        //
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Brand> findByName(String name) {
        Query query =
                entityManager.createQuery(
                        "select b from Brand b " +
                                "where b.name = ?1 " +
                                "and b.deleted = false");
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

    @Override
    public List<Integer> findAllIds() {
        Query query =
                entityManager.createQuery(
                        "select b.id,b.name " +
                                "from Brand b " +
                                "where b.deleted = false");
        return query.getResultList();
    }

    @Override
    public List<CountProduct> countProduct() {
       return entityManager.createQuery("select new " +
                "com.itstudent.entities.query" +
                ".CountProduct(p.brand.name,count(p))" +
                " from Product p group by p.brand ").getResultList();
    }
}
