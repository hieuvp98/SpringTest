package com.itstudent.example.configuaration;

import com.itstudent.example.di.CropTop;
import com.itstudent.example.di.Girl;
import com.itstudent.example.di.Hoodie;
import com.itstudent.example.di.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OutfitConfig {

    @Autowired
    private ApplicationContext context;

    @Bean(initMethod = "init")
    public Girl junVu(){
        Girl girl = new Girl();
        girl.setOutfit(context.getBean(Hoodie.class));
        return girl;
    }

}
