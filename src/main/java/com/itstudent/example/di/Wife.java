package com.itstudent.example.di;


public class Wife {

    private Outfit outfit;

    public void goOut(){
        outfit.wear();
        System.out.println("Wife goes out");
    }
}
