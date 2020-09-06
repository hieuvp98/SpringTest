package com.itstudent.controller;

import com.itstudent.entities.json.JsonResult;
import com.itstudent.exception.BadRequestException;
import com.itstudent.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BasicAdminController<T> {

    private final BaseService<T> service;

    public BasicAdminController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JsonResult<T>> upload(@RequestBody T data) throws Exception {
        try {
            return JsonResult.uploaded(service.save(data));
        } catch (Exception e) {
            throw new BadRequestException(400, "Data is invalid");
        }
    }

    @PutMapping
    public ResponseEntity<JsonResult<String>> update(@RequestBody T data) throws Exception {
        try {
            service.save(data);
            return JsonResult.updated();
        } catch (Exception e) {
            throw new BadRequestException(400, "Data is invalid");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResult<String>> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);
        return JsonResult.deleted();
    }
}
