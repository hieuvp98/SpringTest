package com.itstudent.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @GetMapping(value = "hello")
    public SpringOutfit hello(){
        return new SpringOutfit(1,"uniqlo",2);
    }
}
