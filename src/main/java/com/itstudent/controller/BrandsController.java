package com.itstudent.controller;

import com.itstudent.entities.data.Brand;
import com.itstudent.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public/brands")
public class BrandsController extends BasicPublicController<Brand>{

    public BrandsController(BrandService service) {
        super(service);
    }

}
