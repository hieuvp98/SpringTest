package com.itstudent.repository;

import com.itstudent.entities.data.Brand;
import com.itstudent.entities.data.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ProductRepoCritImpl implements ProductRepoCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> sortByPrice(boolean asc) {
        // tạo jpql query
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        Predicate predicate = builder.equal(root.get("deleted"), false);
        Order order = asc ? builder.asc(root.get("price"))
                : builder.desc(root.get("price"));
        criteriaQuery.select(root).where(predicate).orderBy(order);


        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public boolean delete(Integer id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Product> criteriaUpdate =
                builder.createCriteriaUpdate(Product.class);
        Root<Product> root = criteriaUpdate.from(Product.class);
        criteriaUpdate.set(root.get("deleted"), true);
        return entityManager.createQuery(criteriaUpdate).executeUpdate() > 0;
    }
}
