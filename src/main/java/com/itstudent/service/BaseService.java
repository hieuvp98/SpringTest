package com.itstudent.service;

import com.itstudent.entities.json.PageJson;
import com.itstudent.utils.SpecificationBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class BaseService<T> {

    private final JpaSpecificationExecutor<T> repo;

    private final Class<T> clazz;

    private final EntityManager entityManager;

    public BaseService(JpaSpecificationExecutor<T> repo, Class<T> clazz, EntityManager entityManager) {
        this.repo = repo;
        this.clazz = clazz;
        this.entityManager = entityManager;
    }

    public T save(T data) throws Exception{
        return (T) ((JpaRepository) repo).save(data);
    }

    public void delete(int id) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<T> criteria = builder.createCriteriaUpdate(clazz);
        Root<T> root = criteria.from(clazz);
        criteria.set("deleted", true).where(builder.equal(root.get("id"), id));
    }

    public PageJson<T> filterByPageWithSort(List<String> criteria, Pageable pageable, String sortCriteria) throws Exception {
        return resolveSort(sortCriteria)
                .map(sort -> new PageJson<>(repo.findAll(new SpecificationBuilder<T>().resolve(criteria), PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort))))
                .orElse(new PageJson<>(repo.findAll(new SpecificationBuilder<T>().resolve(criteria), PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()))));
    }


    public List<T> filterWithSort(List<String> criteria, String sortCriteria) throws Exception {
        return resolveSort(sortCriteria)
                .map(sort -> repo.findAll(new SpecificationBuilder<T>().resolve(criteria), sort))
                .orElse(repo.findAll(new SpecificationBuilder<T>().resolve(criteria)));
    }

    private Optional<Sort> resolveSort(String sortCriteria) {
        Sort sort;
        try {
            String[] path = sortCriteria.split("-");
            String field = path[0];
            sort = Sort.by(Sort.Direction.ASC, field);
            if (path.length > 1 && path[1].equalsIgnoreCase("desc")) {
                sort = Sort.by(Sort.Direction.DESC, field);
            }
            return Optional.of(sort);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
