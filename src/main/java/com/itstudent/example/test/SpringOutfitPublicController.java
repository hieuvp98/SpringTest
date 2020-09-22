package com.itstudent.example.test;

import com.itstudent.exception.NotFoundException;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@AllArgsConstructor
public class SpringOutfitPublicController {

    private final
    SpringOutfitService springOutfitService;

    @GetMapping("api/public/spring-outfits")
    @ApiOperation(value = "find all",
            notes = "free",
            response = SpringOutfit.class)
    public ResponseEntity<List<SpringOutfit>> findAll() {
        return ResponseEntity.ok(springOutfitService.sortByName());
    }

    @GetMapping("api/public/spring-outfits/{id}")
    public ResponseEntity<SpringOutfit> findById(@PathVariable("id") int id) throws NotFoundException{
        SpringOutfit outfit = springOutfitService.findById(id);
        if (outfit != null)
            return ResponseEntity.ok(outfit);
        throw new NotFoundException("Spring outfit");
    }
}
