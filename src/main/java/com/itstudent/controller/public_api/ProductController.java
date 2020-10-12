package com.itstudent.controller.public_api;

import com.itstudent.controller.base.BasePublicController;
import com.itstudent.entities.data.Product;
import com.itstudent.service.BaseService;
import com.itstudent.service_impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/product-2")
public class ProductController extends BasePublicController<Product> {

    public ProductController(ProductServiceImpl service) {
        super(service);
    }
}
