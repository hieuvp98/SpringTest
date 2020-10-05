package com.itstudent.utils.specification;

import com.itstudent.entities.data.Brand;
import org.springframework.data.jpa.domain.Specification;

public class BrandSpecification {
    public static Specification<Brand> hasId(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id);
    }
    public static Specification<Brand> nameLike(String text) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), '%' + text + '%');
    }
    public static Specification<Brand> isNotDeleted() {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.isFalse(root.get("deleted"));
    }
}
