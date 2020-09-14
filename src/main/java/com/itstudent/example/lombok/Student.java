package com.itstudent.example.lombok;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id = "1";

    private String name;

    public Student(String id) {
        this.id = id;
    }
}
