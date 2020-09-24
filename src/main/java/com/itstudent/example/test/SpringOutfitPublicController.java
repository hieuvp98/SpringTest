package com.itstudent.example.test;

import com.itstudent.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SpringOutfitPublicController {

    private final
    SpringOutfitService springOutfitService;

    @GetMapping("api/public/spring-outfits")
    public List<SpringOutfit> findAll() {
        return springOutfitService.sortByName();
    }

    @GetMapping("api/public/spring-outfits/{id}")
    public ResponseEntity<SpringOutfit> findById(@PathVariable("id") int id) throws NotFoundException {
        SpringOutfit outfit = springOutfitService.findById(id);
        int a = 5/0;
        if (outfit != null)
            return ResponseEntity.ok(outfit);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("api/public/spring-outfits/param")
    public SpringOutfit findByIdWithParam(@RequestParam(value = "id", required = false, defaultValue = "1") int id){
        return springOutfitService.findById(id);
    }
}
