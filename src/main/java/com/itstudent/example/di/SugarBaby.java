package com.itstudent.example.di;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class SugarBaby {

    private Outfit outfit;

    public void setOutfit( Outfit outfit) {
        this.outfit = outfit;
    }

    public void dating() {
        outfit.wear();
        System.out.println("Dating with sugar baby");
    }
}
