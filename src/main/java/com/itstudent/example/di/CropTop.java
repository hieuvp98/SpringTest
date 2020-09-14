package com.itstudent.example.di;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CropTop implements Outfit{

    public CropTop() {
    }

    @Override
    public void wear() {
        System.out.println("Đã mặc CropTop");
    }
}
