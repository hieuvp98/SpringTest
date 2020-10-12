package com.itstudent.repository;

import com.itstudent.entities.data.Product;

import java.util.List;

public interface ProductRepoCriteria {

    List<Product> sortByPrice(boolean asc);

    boolean delete(Integer id);
}
