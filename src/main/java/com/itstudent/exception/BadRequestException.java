package com.itstudent.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.servlet.ServletException;

@EqualsAndHashCode(callSuper = true)
@Data
public class BadRequestException extends ServletException {

    private int code;

    public BadRequestException(int code, String message) {
        super(message);
        this.code = code;
    }
}
