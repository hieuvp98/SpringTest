package com.itstudent.controller.public_api;

import com.itstudent.controller.base.BasePublicController;
import com.itstudent.entities.data.Brand;
import com.itstudent.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/brands")
public class BrandPublicController extends BasePublicController<Brand> {

    public BrandPublicController(BaseService<Brand> service) {
        super(service);
    }

}
