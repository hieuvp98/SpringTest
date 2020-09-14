package com.itstudent.example.di;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Wife {

    private Outfit outfit;

    public void goOut(){
        outfit.wear();
        System.out.println("Wife goes out");
    }
}
