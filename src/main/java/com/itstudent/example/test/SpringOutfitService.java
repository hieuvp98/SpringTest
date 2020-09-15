package com.itstudent.example.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SpringOutfitService {

    private final SpringOutfitRepo repo;

    public List<SpringOutfit> sortByName() {

        List<SpringOutfit> outfits = repo.findAll();

        outfits.sort(((o1, o2) -> {
          return  o1.getName().compareTo(o2.getName());
        }));

        return outfits;
    }

    public List<SpringOutfit> sortByPrice() {
        List<SpringOutfit> outfits = repo.findAll();
        return outfits.stream().sorted(((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()))).collect(Collectors.toList());
    }
}
