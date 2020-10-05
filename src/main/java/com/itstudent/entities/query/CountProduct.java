package com.itstudent.entities.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountProduct {
    private String topic;
    private Long quantity;
}
