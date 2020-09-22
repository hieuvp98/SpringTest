package com.itstudent.example.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SpringOutfitService_Impl implements SpringOutfitService {

    private final SpringOutfitRepo repo;

    @Override
    public List<SpringOutfit> sortByName() {

        List<SpringOutfit> outfits = repo.findAll();

        outfits.sort(((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        }));

        return outfits;
    }

    @Override
    public List<SpringOutfit> sortByPrice() {
        List<SpringOutfit> outfits = repo.findAll();
        return outfits.stream().sorted(((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()))).collect(Collectors.toList());
    }

    @Override
    public SpringOutfit findById(int id) {
        return repo.findAll()
                .stream()
                .filter(object -> object.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(SpringOutfit springOutfit) {
        List<SpringOutfit> springOutfits = repo.findAll();

        if (springOutfit.getId() == null) {
            springOutfit.setId(springOutfits.size() + 1);
        } else {
            SpringOutfit test = findById(springOutfit.getId());
            if (test != null)
                springOutfits.remove(test);
        }
        springOutfits.add(springOutfit);
    }

    @Override
    public boolean delete(int id) {
        List<SpringOutfit> springOutfits = repo.findAll();
        SpringOutfit test = findById(id);
        if (test != null) {
            springOutfits.remove(test);
            return true;
        }
        return false;
    }
}
