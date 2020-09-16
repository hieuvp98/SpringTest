package com.itstudent.example.test;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@AllArgsConstructor
public class SpringOutController {

    private final SpringOutfitService springOutfitService;

    @GetMapping("api/public/spring-outfits")
    public List<SpringOutfit> findAll(HttpServletRequest request,
                                      HttpServletResponse response){
        request.getCookies();
        request.getParameter("id");
        return springOutfitService.sortByName();
    }

    @GetMapping("api/public/spring-outfits/{name}/{price}")
    public SpringOutfit findByName(@PathVariable("name") String name,
                                   @PathVariable(value = "price", required = false) double price,
                                   @RequestParam(value = "id", required = false, defaultValue = "3") Integer id){
        return springOutfitService.findByName(name);
    }
}
