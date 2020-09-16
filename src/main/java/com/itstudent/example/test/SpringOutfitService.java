package com.itstudent.example.test;

import java.util.List;

public interface SpringOutfitService {

    List<SpringOutfit> sortByName();

    List<SpringOutfit> sortByPrice();

    SpringOutfit findByName(String name);
}
