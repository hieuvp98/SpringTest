package com.itstudent;

import com.itstudent.entities.data.Address;
import com.itstudent.entities.data.Brand;
import com.itstudent.entities.data.Product;
import com.itstudent.repository.BrandRepoExample;
import com.itstudent.repository.BrandRepository;
import com.itstudent.repository.ProductRepo;
import com.itstudent.utils.specification.BrandSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepo productRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        Optional<Product> productOptional = productRepo.findById(1);

        String brandName = productOptional
                .map(p -> p.getBrand())
                .map(b -> b.getName())
                .orElse("not found");

        productOptional.filter(p -> p.getPrice() > 100)
                .ifPresent(p -> System.out.println(p.getPrice()));


        Specification<Brand> conditions = Specification
                .where(BrandSpecification.nameLike("a"))
                .and(BrandSpecification.isNotDeleted())
                .or(BrandSpecification.hasId(1));

        List<Brand> brands = brandRepository.findAll(conditions);
    }
}
