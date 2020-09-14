package com.itstudent.controller.base;

import com.itstudent.entities.json.JsonResult;
import com.itstudent.exception.BadRequestException;
import com.itstudent.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Date;

public class BaseAdminController<T> {

    private final BaseService<T> service;

    public BaseAdminController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JsonResult<T>> upload(@RequestBody T data) throws Exception {
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase("deleted")) {
                field.set(data, false);
            } else if (field.getName().equalsIgnoreCase("created")) {
                field.set(data, new Date().getTime());
            }
        }
        return JsonResult.uploaded(service.save(data));
    }

    @PutMapping
    public ResponseEntity<JsonResult<String>> update(@RequestBody T data) throws Exception {
        service.save(data);
        return JsonResult.updated();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResult<String>> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);
        return JsonResult.deleted();
    }
}
