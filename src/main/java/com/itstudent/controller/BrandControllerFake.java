package com.itstudent.controller;

import com.itstudent.entities.data.Brand;
import com.itstudent.repository.interfac.BrandRepoExample;
import com.itstudent.repository.interfac.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/public/brands")
public class BrandControllerFake {

    private final BrandRepoExample brandRepo;

    private final BrandRepository brandRepository;

    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam(value = "id", required = false) Integer id,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam("field") String field) {

        Brand brand = Brand.builder()
                .id(id)
                .name(name)
                .deleted(false)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withMatcher("name", ExampleMatcher
                        .GenericPropertyMatchers.contains());

        Example<Brand> brandExample = Example.of(brand, matcher);
        Sort sort = Sort.by(field);
        return ResponseEntity.ok(brandRepository.findAll(brandExample, sort).subList(5,10));
    }

    @GetMapping("/page")
    public ResponseEntity<Object> page(Pageable pageable) {
        return ResponseEntity.ok(brandRepository.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById2(@PathVariable("id") int id) {
        return ResponseEntity.ok(brandRepo.findByIdSimple(id));
    }

//    @GetMapping("/ids")
//    public ResponseEntity<Object> findByIds(@RequestParam("ids") List<Integer> ids) {
//        return ResponseEntity.ok(brandRepository.findByIdInAndDeletedFalse(ids));
//    }

    @PostMapping
    public ResponseEntity<String> upload(@RequestBody Brand brand) {
        brandRepository.count(Example.of(Brand.builder().deleted(false).build()));
        if (brandRepo.insert(brand))
            return ResponseEntity.ok("insert success");
        return ResponseEntity.badRequest().build();
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
//        brandRepository.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
