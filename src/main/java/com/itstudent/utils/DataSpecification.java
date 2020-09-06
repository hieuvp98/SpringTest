package com.itstudent.utils;

import com.itstudent.entities.search.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSpecification<T> implements Specification<T> {

    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        try {
            switch (criteria.getOperation()) {
                case ">":
                    return builder.greaterThan(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                case ">=":
                    return builder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                case "<":
                    return builder.lessThan(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                case "<=":
                    return builder.lessThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                case "=":
                    return builder.equal(
                            root.get(criteria.getKey()), criteria.getValue());
                case "==": // for parent comparing
                    return builder.equal(
                            root.get(criteria.getKey()).get("id"), criteria.getValue());
                case "!=":
                    return builder.notEqual(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                case "%":
                    return builder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                case ":":
                    return criteria.getValue().toString().equalsIgnoreCase("null") ?
                            root.get(criteria.getKey()).isNull() : root.get(criteria.getKey()).isNotNull();
                case "<<":
                    return
                            root.get(criteria.getKey()).in(Arrays.stream(criteria.getValue().toString().split(";")).map(str -> (Object) str).toArray());
                default:
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
