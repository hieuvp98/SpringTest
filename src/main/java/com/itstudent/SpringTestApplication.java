package com.itstudent;

import com.itstudent.aop.LogAfter;
import com.itstudent.aop.LogTime;
import com.itstudent.repository.interfac.AddressRepo;
import com.itstudent.repository.interfac.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class SpringTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {

    }

}
