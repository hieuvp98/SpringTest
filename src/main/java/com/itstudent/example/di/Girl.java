package com.itstudent.example.di;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
public class Girl {

    private Hoodie outfit;

    public void init(){
    }
}
