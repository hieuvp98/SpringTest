package com.itstudent.example.test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/admin/spring-outfit")
public class SpringOutfitAdminController {

    @Autowired
    private SpringOutfitService springOutfitService;

    @PostMapping
    public String upload(@RequestBody SpringOutfit springOutfit){
        //insert here
        springOutfitService.save(springOutfit);
        return "insert success";
    }

    @PutMapping
    public String update(@RequestBody SpringOutfit springOutfit){
        springOutfitService.save(springOutfit);
        return "update success";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        if (springOutfitService.delete(id)){
            return ResponseEntity.ok("delete success");
        }
        return ResponseEntity.notFound().build();
    }
}
