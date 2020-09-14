package com.itstudent.example.di;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
public class Bikini implements Outfit{

    private String type;

    @PostConstruct
    public void init(){
        System.out.println("Bikini được tạo");
        type = "Hai mảnh";
    }

    public Bikini() {
        System.out.println("Bikini init ");
    }

    @Override
    public void wear() {
        System.out.println("Đã mặc bikini");
    }
}
