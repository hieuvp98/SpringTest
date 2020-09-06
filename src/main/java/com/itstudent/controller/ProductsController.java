package com.itstudent.controller;

import com.itstudent.entities.data.Brand;
import com.itstudent.entities.data.Product;
import com.itstudent.entities.json.JsonResult;
import com.itstudent.entities.json.PageJson;
import com.itstudent.service.BaseService;
import com.itstudent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/public/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<JsonResult<PageJson<Product>>> query(@RequestParam(value = "queries", required = false) List<String> queries,
                                                               @RequestParam(value = "sort", required = false) String sort,
                                                               Pageable pageable) throws Exception{
        return JsonResult.success(productService.filterByPageWithSort(queries, pageable, sort));
    }
}
