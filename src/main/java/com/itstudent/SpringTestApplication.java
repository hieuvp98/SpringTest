package com.itstudent;

import com.itstudent.entities.data.Address;
import com.itstudent.entities.data.Brand;
import com.itstudent.repository.BrandRepoExample;
import com.itstudent.repository.BrandRepository;
import com.itstudent.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class SpringTestApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @Autowired
    private BrandRepoExample example;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(productRepo.countProductByBrand());
    }
}
