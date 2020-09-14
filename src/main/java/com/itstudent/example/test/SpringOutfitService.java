package com.itstudent.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpringOutfitService {

    private final SpringOutfitRepo repo;

    public void sortByName(){
       List<SpringOutfit> outfits = repo.findAll();
       outfits.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));

    }

    public void sortByPrice(){
        List<SpringOutfit> outfits = repo.findAll();
        outfits.sort(((o1, o2) -> (int)(o2.getPrice() - o1.getPrice())));
    }
}
