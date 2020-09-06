package com.itstudent.controller;

import com.itstudent.entities.data.Brand;
import com.itstudent.service.BaseService;
import com.itstudent.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public/brand")
public class BrandAdminController extends BasicAdminController<Brand>{

    public BrandAdminController(BaseService<Brand> service) {
        super(service);
    }
}
