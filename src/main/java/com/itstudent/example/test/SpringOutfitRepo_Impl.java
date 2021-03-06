package com.itstudent.example.test;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpringOutfitRepo_Impl implements SpringOutfitRepo{

    private List<SpringOutfit> springOutfits;

    @PostConstruct
    public void fakeData(){

        springOutfits = new ArrayList<>();

        springOutfits.add(SpringOutfit
                .builder()
                .id(1)
                .name("H&M")
                .price(5)
                .build());

        springOutfits.add(SpringOutfit
                .builder()
                .id(2)
                .name("Louis Vuiton")
                .price(4)
                .build());
    }

    @Override
    public List<SpringOutfit> findAll() {
        return springOutfits;
    }
}
