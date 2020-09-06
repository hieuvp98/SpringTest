package com.itstudent.exception;

import com.itstudent.entities.json.JsonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<JsonResult> handler(Exception e){
        e.printStackTrace();
        return JsonResult.error(e);
    }

    @ExceptionHandler
    public ResponseEntity<JsonResult> handlerNotFound(NotFoundException e){
        e.printStackTrace();
        return JsonResult.notFound(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<JsonResult> handlerBadRequest(BadRequestException e){
        e.printStackTrace();
        return JsonResult.badRequest(400,e.getMessage());
    }
}
