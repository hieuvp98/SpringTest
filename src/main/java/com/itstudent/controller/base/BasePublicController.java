package com.itstudent.controller.base;

import com.itstudent.entities.json.JsonResult;
import com.itstudent.entities.json.PageJson;
import com.itstudent.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class BasePublicController<T> {

    private final BaseService<T> service;

    public BasePublicController(BaseService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<JsonResult<List<T>>> search(@RequestParam(value = "queries", required = false) List<String> queries,
                                                      @RequestParam(value = "sort", required = false) String sort) throws Exception{
        return JsonResult.success(service.filterWithSort(queries, sort));
    }

    @GetMapping("/page")
    public ResponseEntity<JsonResult<PageJson<T>>> searchWithPage(@RequestParam(value = "queries", required = false) List<String> queries,
                                                                @RequestParam(value = "sort", required = false) String sort, Pageable pageable) throws Exception{
        return JsonResult.success(service.filterByPageWithSort(queries, pageable, sort));
    }
}