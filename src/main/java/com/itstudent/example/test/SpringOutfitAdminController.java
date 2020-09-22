package com.itstudent.example.test;

import org.springframework.beans.factory.annotation.Autowired;
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
        springOutfit.setId(null);
        springOutfitService.save(springOutfit);
        return "insert success";
    }

    @PutMapping
    public String update(@RequestBody SpringOutfit springOutfit){
        springOutfitService.save(springOutfit);
        return "update success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id,
                         HttpServletResponse response){
        if (springOutfitService.delete(id)){
            return "delete success";
        }else {
            response.setStatus(400); // bad request
            return "id is not exist";
        }
    }
}
