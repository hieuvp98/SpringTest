package com.itstudent;

import com.itstudent.entities.data.Address;
import com.itstudent.entities.data.Brand;
import com.itstudent.entities.data.Customer;
import com.itstudent.repository.AddressRepo;
import com.itstudent.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    private AddressRepo addressRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        addressRepo.findById2(6)
        .ifPresent(a -> System.out.println(a.getCustomer().getName()));
    }
}
