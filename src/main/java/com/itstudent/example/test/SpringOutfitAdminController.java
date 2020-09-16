package com.itstudent.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/spring-outfit")
public class SpringOutfitAdminController {

    @Autowired
    private SpringOutfitService springOutfitService;

    @PostMapping
    public String upload(@RequestBody SpringOutfit springOutfit){
        //insert here
        return null;
    }

    @PutMapping
    public String update(@RequestBody SpringOutfit springOutfit){
        //update here
        return "abc";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        //delete here
        return null;
    }
}
